package com.lucasprioste.batterymanager.core.battery_manager.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import com.lucasprioste.batterymanager.R
import com.lucasprioste.batterymanager.domain.model.battery_manager.BatteryData
import java.util.Date

class BatteryChangePublisher(
    private val context: Context,
    private val listener: BatteryListener
) {
    private lateinit var broadcastReceiver: BroadcastReceiver
    private val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
    fun registerReceiver(){
        broadcastReceiver = BatteryManagerBroadcastReceiver{
            val status: Int = it.getIntExtra(BatteryManager.EXTRA_STATUS, -1)

            val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL ||
                    it.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) != 0

            val batteryLow = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
                it.getBooleanExtra(BatteryManager.EXTRA_BATTERY_LOW, false)
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
                    level = it.getIntExtra(BatteryManager.EXTRA_LEVEL, DEFAULT_INT),
                    isCharging = isCharging,
                    iconSmall = it.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, DEFAULT_ICON),
                    health = it.getIntExtra(BatteryManager.EXTRA_HEALTH, DEFAULT_INT),
                    status = it.getIntExtra(BatteryManager.EXTRA_STATUS, DEFAULT_INT),
                    scale = it.getIntExtra(BatteryManager.EXTRA_SCALE, DEFAULT_INT),
                    plugged = it.getIntExtra(BatteryManager.EXTRA_PLUGGED, DEFAULT_INT),
                    present = it.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false),
                    technology = it.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY),
                    batteryLow = batteryLow,
                    voltage = it.getIntExtra(BatteryManager.EXTRA_VOLTAGE, DEFAULT_INT),
                    temperature = it.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, DEFAULT_INT),
                    propertyCapacity = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY),
                    propertyChargeCounter = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER),
                    propertyEnergyCounter = batteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER),
                    propertyCurrentAverage = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_AVERAGE),
                    propertyCurrentNow = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW),
                    propertyStatus = propertyStatus,
                    chargeTimeRemaining = chargeTimeRemaining,
                    action = it.action.toString(),
                )
            )
        }
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        context.registerReceiver(broadcastReceiver, filter)
    }

    fun unRegisterReceiver(){
        context.unregisterReceiver(broadcastReceiver)
    }

    companion object {
        const val DEFAULT_INT = -99
        const val DEFAULT_LONG = -99L
        val DEFAULT_ICON = R.drawable.default_icon_battery
    }
}