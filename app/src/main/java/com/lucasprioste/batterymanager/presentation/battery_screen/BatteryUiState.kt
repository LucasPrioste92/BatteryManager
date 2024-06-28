package com.lucasprioste.batterymanager.presentation.battery_screen

import com.lucasprioste.batterymanager.core.battery_manager.model.BatteryData

data class BatteryUiState(
    val batteryInfo: BatteryData = BatteryData()
)
