package com.lucasprioste.energydroid.domain.model

/**
 * Represents the status of a battery.
 */
sealed interface BatteryStatus {

    /**
     * Indicates the battery is fully charged.
     */
    data object Full : BatteryStatus

    /**
     * Indicates the battery is not charging.
     */
    data object NotCharging : BatteryStatus

    /**
     * Indicates the battery is discharging.
     */
    data object Discharging : BatteryStatus

    /**
     * Indicates the battery is charging.
     */
    data object Charging : BatteryStatus

    /**
     * Indicates the battery status is unknown.
     */
    data object Unknown : BatteryStatus
}