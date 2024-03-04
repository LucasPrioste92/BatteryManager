package com.lucasprioste.batterymanager.presentation.battery_screen

import com.lucasprioste.batterymanager.domain.model.battery_manager.BatteryData

data class BatteryUiState(
    val batteryInfo: BatteryData = BatteryData()
)
