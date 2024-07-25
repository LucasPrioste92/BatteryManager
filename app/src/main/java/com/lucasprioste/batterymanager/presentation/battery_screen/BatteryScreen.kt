package com.lucasprioste.batterymanager.presentation.battery_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasprioste.batterymanager.presentation.ui.theme.BatteryManagerTheme
import io.github.lucasprioste92.energydroid.domain.model.BatteryData

@Composable
fun BatteryScreen(
    batteryData: BatteryData,
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${batteryData.level}% - Is Charging: ${batteryData.isCharging} - Status: ${batteryData.status}")
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BatteryScreenPreview() {
    BatteryManagerTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BatteryScreen(
                batteryData = BatteryData(
                    level = 90,
                    isCharging = false
                ),
            )
        }
    }
}