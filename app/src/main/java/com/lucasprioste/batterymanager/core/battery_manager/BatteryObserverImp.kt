package com.lucasprioste.batterymanager.core.battery_manager

import android.content.Context
import com.lucasprioste.batterymanager.core.battery_manager.broadcast_receiver.BatteryController
import com.lucasprioste.batterymanager.core.battery_manager.model.BatteryData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

class BatteryObserverImp(
    private val context: Context,
): BatteryObserver {
    override fun observe() = callbackFlow {
        val batteryController = BatteryController(
            context = context,
            listener = { data ->
                launch { send(data) }
            },
        )

        batteryController.registerReceiver()
        awaitClose {
            batteryController.unRegisterReceiver()
        }
    }.distinctUntilChanged()

    override suspend fun latestData(): BatteryData = observe().take(1).first()
}