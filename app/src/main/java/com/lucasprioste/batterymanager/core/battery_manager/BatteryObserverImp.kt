package com.lucasprioste.batterymanager.core.battery_manager

import android.content.Context
import com.lucasprioste.batterymanager.core.battery_manager.broadcastReceiver.BatteryChangePublisher
import com.lucasprioste.batterymanager.core.battery_manager.broadcastReceiver.BatteryListener
import com.lucasprioste.batterymanager.domain.model.battery_manager.BatteryData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class BatteryObserverImp(
    private val context: Context,
): BatteryObserver {
    override fun observe(): Flow<BatteryData> {
        return callbackFlow {
            val batteryObserver = object : BatteryListener {
                override fun change(data: BatteryData) {
                    launch { send(data) }
                }
            }
            val batteryChangePublisher = BatteryChangePublisher(context = context, listener = batteryObserver)
            batteryChangePublisher.registerReceiver()
            awaitClose {
                batteryChangePublisher.unRegisterReceiver()
            }
        }.distinctUntilChanged()
    }
}