package io.github.lucasprioste92.energydroid.domain.model

/**
 * Represents the plugged state of a battery.
 */
sealed interface BatteryPlugged {

    /**
     * Indicates the battery is plugged in via AC power.
     */
    data object AC : BatteryPlugged

    /**
     * Indicates the battery is plugged in via USB.
     */
    data object USB : BatteryPlugged

    /**
     * Indicates the battery is charging wireless.
     */
    data object Wireless : BatteryPlugged

    /**
     * Indicates the battery is plugged into a dock.
     */
    data object Dock : BatteryPlugged

    /**
     * Indicates the battery is currently running on battery power.
     */
    data object OnBattery : BatteryPlugged

    /**
     * Indicates the battery plugged state is unknown.
     */
    data object Unknown : BatteryPlugged
}