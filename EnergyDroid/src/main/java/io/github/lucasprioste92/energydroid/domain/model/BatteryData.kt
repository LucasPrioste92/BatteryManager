package io.github.lucasprioste92.energydroid.domain.model


import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_CAPACITY
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_CHARGE_COUNTER
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_CHARGING
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_CURRENT_AVERAGE
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_CURRENT_NOW
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_ENERGY_COUNTER
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_LEVEL
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_PRESENT
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_SCALE
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_TEMPERATURE
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_VOLTAGE
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
 * @property chargeCounter The charge counter of the battery in microamps-hours.
 * @property currentAverage The average current of the battery in microamps. Positive values indicate net current entering the battery from a charge source, negative values indicate net current discharging from the battery..
 * @property currentNow The current battery current in microamperes. Positive values indicate net current entering the battery from a charge source, negative values indicate net current discharging from the battery.
 * @property energyCounter Battery remaining energy in nanowatt-hours.
 * @property batteryLow Whether the battery is currently considered to be low (for API level 28 and above).
 * @property chargeTimeRemaining The estimated remaining charge time in milliseconds, -1 if no time can be computed (for API level 29 and above).
 */
data class BatteryData(
    /**
     * The time at which the battery data was recorded.
     */
    val timestamp: LocalDateTime = LocalDateTime.now(),
    /**
     * The health status of the battery.
     */
    val health: BatteryHealthStatus = BatteryHealthStatus.Unknown,
    /**
     * The current status of the battery (e.g., charging, full).
     */
    val status: BatteryStatus = BatteryStatus.Unknown,
    /**
     * Whether the battery is currently charging.
     */
    val isCharging: Boolean = DEFAULT_CHARGING,
    /**
     * The current voltage in millivolts of the battery.
     */
    val voltage: Int = DEFAULT_VOLTAGE,
    /**
     * The current temperature in tenths of a degree Centigrade of the battery.
     */
    val temperature: Int = DEFAULT_TEMPERATURE,
    /**
     * The technology of the battery (e.g., Li-ion).
     */
    val technology: String? = null,
    /**
     * The current battery level in percentage.
     */
    val level: Int = DEFAULT_LEVEL,
    /**
     * The maximum battery level.
     */
    val scale: Int = DEFAULT_SCALE,
    /**
     * Whether the battery is present in the device.
     */
    val present: Boolean = DEFAULT_PRESENT,
    /**
     * The type of power source that the device is plugged into.
     */
    val plugged: BatteryPlugged = BatteryPlugged.Unknown,
    /**
     * Remaining battery capacity as an integer percentage of total capacity (with no fractional part).
     */
    val capacity: Int = DEFAULT_CAPACITY,
    /**
     * The charge counter of the battery in microamps-hours.
     */
    val chargeCounter: Int = DEFAULT_CHARGE_COUNTER,
    /**
     * The average current of the battery in microamps. Positive values indicate net current entering the battery from a charge source, negative values indicate net current discharging from the battery..
     */
    val currentAverage: Int = DEFAULT_CURRENT_AVERAGE,
    /**
     * The current battery current in microamperes. Positive values indicate net current entering the battery from a charge source, negative values indicate net current discharging from the battery.
     */
    val currentNow: Int = DEFAULT_CURRENT_NOW,
    /**
     * Battery remaining energy in nanowatt-hours.
     */
    val energyCounter: Long = DEFAULT_ENERGY_COUNTER,
    /**
     * Whether the battery is currently considered to be low (for API level 28 and above).
     */
    val batteryLow: Boolean? = null, // Min API Level 28
    /**
     * The estimated remaining charge time in milliseconds, -1 if no time can be computed (for API level 29 and above).
     */
    val chargeTimeRemaining: Long? = null, // Min. API Level 29
)