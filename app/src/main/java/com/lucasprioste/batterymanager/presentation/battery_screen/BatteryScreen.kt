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

@Composable
fun BatteryScreen(

){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "100%")
        Text(text = "Is Charging:")
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
            BatteryScreen()
        }
    }
}