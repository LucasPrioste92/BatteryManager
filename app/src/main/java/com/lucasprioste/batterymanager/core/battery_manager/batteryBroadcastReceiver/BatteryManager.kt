package com.lucasprioste.batterymanager.core.battery_manager.batteryBroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import com.lucasprioste.batterymanager.R
import com.lucasprioste.batterymanager.domain.model.battery_manager.BatteryData
import java.util.Date

/**
 * A manager class to handle battery-related broadcasts and data.
 *
 * This class extends [BroadcastReceiver] and is responsible for registering and unregistering
 * a broadcast receiver to listen for battery change events. It processes the received battery
 * change intents and extracts relevant battery information to notify a [BatteryListener].
 *
 * @property context The context in which the receiver is running.
 * @property listener The listener to notify with battery data changes.
 */
class BatteryManager(
    private val context: Context,
    private val listener: BatteryListener
): BroadcastReceiver() {
    /**
     * A [BatteryManager] instance to access battery-related information and properties.
     *
     * This property initializes a [BatteryManager] using the context's [Context.BATTERY_SERVICE].
     * The [BatteryManager] provides methods to query various battery properties and status.
     *
     * @property batteryManager The [BatteryManager] instance retrieved from the context.
     * @see BatteryManager
     */
    private val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

    /**
     * Registers a broadcast receiver to listen for battery change events.
     *
     * This function creates an [IntentFilter] to listen for [Intent.ACTION_BATTERY_CHANGED] events
     * and registers the [BroadcastReceiver] with the context using this filter. The receiver will
     * then receive broadcasts whenever the battery status changes.
     *
     * Note: Ensure to call [unRegisterReceiver] to unregister the receiver when it is no longer needed
     * to avoid memory leaks.
     */
    fun registerReceiver() {
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        context.registerReceiver(this, filter)
    }

    /**
     * Unregisters the broadcast receiver from the context.
     *
     * This function unregisters the previously registered [BroadcastReceiver] from the context to
     * stop receiving broadcasts. It should be called to clean up resources when the broadcast
     * receiver is no longer needed.
     */
    fun unRegisterReceiver() = context.unregisterReceiver(this)

    /**
     * Handles battery change events and extracts relevant battery information from the intent.
     *
     * This function is called when a battery change event is received. It extracts various battery-related
     * data from the [Intent] and passes this data to the [listener] as a [BatteryData] object.
     *
     * @param intent The [Intent] containing battery change information.
     */
    private fun onBatteryChange(intent: Intent) {
        val status: Int = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)

        val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL ||
                intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) != 0

        val batteryLow = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
            intent.getBooleanExtra(BatteryManager.EXTRA_BATTERY_LOW, false)
        else null

        val propertyStatus = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS)
        else null

        val chargeTimeRemaining = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
            batteryManager.computeChargeTimeRemaining()
        else null

        listener.change(
            data = BatteryData(
                timestamp = Date(),
                level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, DEFAULT_INT),
                isCharging = isCharging,
                iconSmall = intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, DEFAULT_ICON),
                health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, DEFAULT_INT),
                status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, DEFAULT_INT),
                scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, DEFAULT_INT),
                plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, DEFAULT_INT),
                present = intent.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false),
                technology = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY),
                batteryLow = batteryLow,
                voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, DEFAULT_INT),
                temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, DEFAULT_INT),
                propertyCapacity = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY),
                propertyChargeCounter = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER),
                propertyEnergyCounter = batteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER),
                propertyCurrentAverage = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_AVERAGE),
                propertyCurrentNow = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW),
                propertyStatus = propertyStatus,
                chargeTimeRemaining = chargeTimeRemaining,
                action = intent.action.toString(),
            )
        )
    }

    /**
     * Receives broadcast intents and handles battery change events.
     *
     * This function is called when a broadcast matching the specified [IntentFilter] is received.
     * If the received intent's action is [Intent.ACTION_BATTERY_CHANGED], it calls [onBatteryChange]
     * to process the battery change information.
     *
     * @param context The context in which the receiver is running.
     * @param intent The intent being received.
     */
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BATTERY_CHANGED) onBatteryChange(intent = intent)
    }

    companion object {
        const val DEFAULT_INT = -1
        const val DEFAULT_LONG = -1L
        val DEFAULT_ICON = R.drawable.default_icon_battery
    }
}