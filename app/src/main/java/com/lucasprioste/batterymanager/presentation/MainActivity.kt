package com.lucasprioste.batterymanager.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lucasprioste.batterymanager.presentation.battery_screen.BatteryScreen
import com.lucasprioste.batterymanager.presentation.battery_screen.BatteryViewModel
import com.lucasprioste.batterymanager.presentation.ui.theme.BatteryManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatteryManagerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val batteryViewModel: BatteryViewModel = hiltViewModel()
                    val uiState = batteryViewModel.uiState.collectAsStateWithLifecycle().value
                    BatteryScreen(
                        batteryData = uiState.batteryInfo,
                    )
                }
            }
        }
    }

}