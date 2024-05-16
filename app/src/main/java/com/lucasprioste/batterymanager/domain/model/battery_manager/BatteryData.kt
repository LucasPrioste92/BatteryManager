package com.lucasprioste.batterymanager.domain.model.battery_manager

import android.os.BatteryManager
import com.lucasprioste.batterymanager.core.battery_manager.batteryBroadcastReceiver.BatteryManager.Companion.DEFAULT_ICON
import com.lucasprioste.batterymanager.core.battery_manager.batteryBroadcastReceiver.BatteryManager.Companion.DEFAULT_INT
import com.lucasprioste.batterymanager.core.battery_manager.batteryBroadcastReceiver.BatteryManager.Companion.DEFAULT_LONG
import java.util.Date

data class BatteryData(
    val timestamp: Date = Date(),
    val iconSmall: Int = DEFAULT_ICON,
    val action: String = "",
    val health: Int = DEFAULT_INT,
    val status: Int = DEFAULT_INT,
    val voltage: Int = DEFAULT_INT,
    val temperature: Int = DEFAULT_INT,
    val technology: String? = null,
    val level: Int = DEFAULT_INT,
    val scale: Int = DEFAULT_INT,
    val present: Boolean = false,
    val plugged: Int = DEFAULT_INT,
    val propertyCapacity: Int = DEFAULT_INT,
    val propertyChargeCounter: Int = DEFAULT_INT,
    val propertyCurrentAverage: Int = DEFAULT_INT,
    val propertyCurrentNow: Int = DEFAULT_INT,
    val propertyEnergyCounter: Long = DEFAULT_LONG,
    val isCharging: Boolean = false,
    // Min. API Level 26
    val propertyStatus: Int? = null,
    // Min API Level 28
    val batteryLow: Boolean? = null,
    // Min. API Level 29
    val chargeTimeRemaining: Long? = null,
){
    fun getBatteryHealthText(): String {
        return when (this.health) {
            BatteryManager.BATTERY_HEALTH_COLD -> "Cold"
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "Unspecified Failure"
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
            BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheat"
            BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
            BatteryManager.BATTERY_HEALTH_UNKNOWN -> "Unknown"
            else -> "Unknown"
        }
    }

    fun getBatteryStatusText(): String {
        return when (this.status) {
            BatteryManager.BATTERY_STATUS_FULL -> "Full"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "Not Charging"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> "Discharging"
            BatteryManager.BATTERY_STATUS_CHARGING -> "Charging"
            BatteryManager.BATTERY_STATUS_UNKNOWN -> "Unknown"
            else -> "Unknown"
        }
    }

    fun getBatteryPluggedText(): String {
        return when (this.plugged) {
            BatteryManager.BATTERY_PLUGGED_AC -> "AC"
            BatteryManager.BATTERY_PLUGGED_USB -> "USB"
            BatteryManager.BATTERY_PLUGGED_WIRELESS -> "Wireless"
            else -> "Unknown"
        }
    }
}