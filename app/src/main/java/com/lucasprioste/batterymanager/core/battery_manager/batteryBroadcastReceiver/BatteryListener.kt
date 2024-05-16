package com.lucasprioste.batterymanager.core.battery_manager.batteryBroadcastReceiver

import com.lucasprioste.batterymanager.domain.model.battery_manager.BatteryData

interface BatteryListener{
    fun change(data: BatteryData)
}