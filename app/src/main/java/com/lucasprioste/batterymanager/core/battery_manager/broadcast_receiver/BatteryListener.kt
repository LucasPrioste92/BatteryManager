package com.lucasprioste.batterymanager.core.battery_manager.broadcast_receiver

import com.lucasprioste.batterymanager.core.battery_manager.model.BatteryData

interface BatteryListener {
    fun change(data: BatteryData)
}