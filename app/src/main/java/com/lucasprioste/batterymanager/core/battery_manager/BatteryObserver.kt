package com.lucasprioste.batterymanager.core.battery_manager

import com.lucasprioste.batterymanager.domain.model.battery_manager.BatteryData
import kotlinx.coroutines.flow.Flow

interface BatteryObserver {
    fun observe(): Flow<BatteryData>

}