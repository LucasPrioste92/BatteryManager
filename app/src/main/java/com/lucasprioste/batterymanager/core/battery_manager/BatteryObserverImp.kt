package com.lucasprioste.batterymanager.core.battery_manager

import android.content.Context
import com.lucasprioste.batterymanager.core.battery_manager.batteryBroadcastReceiver.BatteryManager
import com.lucasprioste.batterymanager.core.battery_manager.batteryBroadcastReceiver.BatteryListener
import com.lucasprioste.batterymanager.domain.model.battery_manager.BatteryData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class BatteryObserverImp(
    private val context: Context,
): BatteryObserver {
    override fun observe() = callbackFlow {
        val batteryListener = object : BatteryListener {
            override fun change(data: BatteryData) {
                launch { send(data) }
            }
        }
        val batteryManager = BatteryManager(context = context, listener = batteryListener)

        batteryManager.registerReceiver()
        awaitClose {
            batteryManager.unRegisterReceiver()
        }
    }.distinctUntilChanged()
}