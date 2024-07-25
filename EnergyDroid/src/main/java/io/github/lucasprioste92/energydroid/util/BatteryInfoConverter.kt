package io.github.lucasprioste92.energydroid.util

import android.os.BatteryManager
import io.github.lucasprioste92.energydroid.domain.model.BatteryHealthStatus
import io.github.lucasprioste92.energydroid.domain.model.BatteryPlugged
import io.github.lucasprioste92.energydroid.domain.model.BatteryStatus
import io.github.lucasprioste92.energydroid.util.DefaultBatteryValues.DEFAULT_PLUGGED

fun Int.toBatteryHealthStatus() = when(this) {
    BatteryManager.BATTERY_HEALTH_COLD -> BatteryHealthStatus.Cold
    BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> BatteryHealthStatus.UnspecifiedFailure
    BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> BatteryHealthStatus.OverVoltage
    BatteryManager.BATTERY_HEALTH_DEAD -> BatteryHealthStatus.Dead
    BatteryManager.BATTERY_HEALTH_OVERHEAT -> BatteryHealthStatus.Overheat
    BatteryManager.BATTERY_HEALTH_GOOD -> BatteryHealthStatus.Good
    else -> BatteryHealthStatus.Unknown
}

fun Int.toBatteryStatus() = when(this) {
    BatteryManager.BATTERY_STATUS_FULL -> BatteryStatus.Full
    BatteryManager.BATTERY_STATUS_NOT_CHARGING -> BatteryStatus.NotCharging
    BatteryManager.BATTERY_STATUS_DISCHARGING -> BatteryStatus.Discharging
    BatteryManager.BATTERY_STATUS_CHARGING -> BatteryStatus.Charging
    else -> BatteryStatus.Unknown
}

fun Int.toBatteryPlugged() = when(this) {
    BatteryManager.BATTERY_PLUGGED_AC -> BatteryPlugged.AC
    BatteryManager.BATTERY_PLUGGED_USB -> BatteryPlugged.USB
    BatteryManager.BATTERY_PLUGGED_WIRELESS -> BatteryPlugged.Wireless
    BatteryManager.BATTERY_PLUGGED_DOCK -> BatteryPlugged.Dock
    DEFAULT_PLUGGED -> BatteryPlugged.OnBattery
    else -> BatteryPlugged.Unknown
}