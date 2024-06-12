package com.lucasprioste.batterymanager.core.battery_manager.model

import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_CAPACITY
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_CHARGE_COUNTER
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_CHARGING
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_CURRENT_AVERAGE
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_CURRENT_NOW
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_ENERGY_COUNTER
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_LEVEL
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_PRESENT
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_SCALE
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_TEMPERATURE
import com.lucasprioste.batterymanager.core.battery_manager.util.DefaultBatteryValues.DEFAULT_VOLTAGE
import java.time.LocalDateTime

/**
 * Data class representing various battery-related information.
 *
 * This class holds detailed battery information, including its status, health, level, and other properties.
 *
 * @property timestamp The time at which the battery data was recorded.
 * @property health The health status of the battery.
 * @property status The current status of the battery (e.g., charging, full).
 * @property isCharging Whether the battery is currently charging.
 * @property voltage The current voltage in millivolts of the battery.
 * @property temperature The current temperature in tenths of a degree Centigrade of the battery.
 * @property technology The technology of the battery (e.g., Li-ion).
 * @property level The current battery level in percentage.
 * @property scale The maximum battery level.
 * @property present Whether the battery is present in the device.
 * @property plugged The type of power source that the device is plugged into.
 * @property capacity Remaining battery capacity as an integer percentage of total capacity (with no fractional part).
 * @property chargeCounter The charge counter of the battery in microampere-hours.
 * @property currentAverage The average current of the battery in microamperes. Positive values indicate net current entering the battery from a charge source, negative values indicate net current discharging from the battery..
 * @property currentNow The current battery current in microamperes. Positive values indicate net current entering the battery from a charge source, negative values indicate net current discharging from the battery.
 * @property energyCounter Battery remaining energy in nanowatt-hours.
 * @property batteryLow Whether the battery is currently considered to be low (for API level 28 and above).
 * @property chargeTimeRemaining The estimated remaining charge time in milliseconds, -1 if no time can be computed (for API level 29 and above).
 */
data class BatteryData(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val health: BatteryHealthStatus = BatteryHealthStatus.Unknown,
    val status: BatteryStatus = BatteryStatus.Unknown,
    val isCharging: Boolean = DEFAULT_CHARGING,
    val voltage: Int = DEFAULT_VOLTAGE,
    val temperature: Int = DEFAULT_TEMPERATURE,
    val technology: String? = null,
    val level: Int = DEFAULT_LEVEL,
    val scale: Int = DEFAULT_SCALE,
    val present: Boolean = DEFAULT_PRESENT,
    val plugged: BatteryPlugged = BatteryPlugged.Unknown,
    val capacity: Int = DEFAULT_CAPACITY,
    val chargeCounter: Int = DEFAULT_CHARGE_COUNTER,
    val currentAverage: Int = DEFAULT_CURRENT_AVERAGE,
    val currentNow: Int = DEFAULT_CURRENT_NOW,
    val energyCounter: Long = DEFAULT_ENERGY_COUNTER,
    val batteryLow: Boolean? = null, // Min API Level 28
    val chargeTimeRemaining: Long? = null, // Min. API Level 29
)