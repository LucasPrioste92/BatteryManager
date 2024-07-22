package com.lucasprioste.batterymanager.presentation.battery_screen

import com.lucasprioste.energydroid.domain.model.BatteryData

data class BatteryUiState(
    val batteryInfo: BatteryData = BatteryData()
)
