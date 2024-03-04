package com.lucasprioste.batterymanager.core.battery_manager.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BatteryManagerBroadcastReceiver(
    private val onReceiveIntent: (Intent) -> Unit,
) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BATTERY_CHANGED)
            onReceiveIntent(intent)
    }
}