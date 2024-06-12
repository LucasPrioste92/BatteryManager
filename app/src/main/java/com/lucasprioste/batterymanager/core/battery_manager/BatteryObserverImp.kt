package com.lucasprioste.batterymanager.core.battery_manager

import android.content.Context
import com.lucasprioste.batterymanager.core.battery_manager.broadcast_receiver.BatteryController
import com.lucasprioste.batterymanager.core.battery_manager.broadcast_receiver.BatteryListener
import com.lucasprioste.batterymanager.core.battery_manager.model.BatteryData
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
        val batteryController = BatteryController(context = context, listener = batteryListener)

        batteryController.registerReceiver()
        awaitClose {
            batteryController.unRegisterReceiver()
        }
    }.distinctUntilChanged()
}