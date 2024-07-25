package com.lucasprioste.batterymanager.presentation.battery_screen

import io.github.lucasprioste92.energydroid.domain.model.BatteryData

data class BatteryUiState(
    val batteryInfo: BatteryData = BatteryData()
)
