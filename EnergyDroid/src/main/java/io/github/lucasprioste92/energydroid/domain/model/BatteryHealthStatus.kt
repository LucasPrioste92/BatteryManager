package io.github.lucasprioste92.energydroid.domain.model

/**
 * Represents the health status of a battery.
 */
sealed interface BatteryHealthStatus {
    /**
     * Indicates the battery is too cold.
     */
    data object Cold: BatteryHealthStatus

    /**
     * Indicates an unspecified failure in the battery.
     */
    data object UnspecifiedFailure: BatteryHealthStatus

    /**
     * Indicates the battery is experiencing over voltage.
     */
    data object OverVoltage: BatteryHealthStatus

    /**
     * Indicates the battery is dead.
     */
    data object Dead: BatteryHealthStatus

    /**
     * Indicates the battery is overheating.
     */
    data object Overheat: BatteryHealthStatus

    /**
     * Indicates the battery is in good health.
     */
    data object Good: BatteryHealthStatus

    /**
     * Indicates the battery health status is unknown.
     */
    data object Unknown: BatteryHealthStatus
}