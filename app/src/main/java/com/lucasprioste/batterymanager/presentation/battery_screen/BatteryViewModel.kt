package com.lucasprioste.batterymanager.presentation.battery_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasprioste.energydroid.BatteryObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatteryViewModel @Inject constructor(
    private val batteryObserver: BatteryObserver
): ViewModel() {

    private val _uiState = MutableStateFlow(BatteryUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getInfoBattery()
    }

    private fun getInfoBattery() {
        viewModelScope.launch {
            batteryObserver.observe().collect{ data ->
                _uiState.update { it.copy(batteryInfo = data) }
            }
        }
    }
}