package com.lucasprioste.energydroid

import android.content.Context
import com.lucasprioste.energydroid.data.broadcast_receiver.BatteryController
import com.lucasprioste.energydroid.data.broadcast_receiver.BatteryListener
import com.lucasprioste.energydroid.domain.model.BatteryData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

class EnergyDroid(
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

    override suspend fun latestData(): BatteryData = observe().take(1).first()
}