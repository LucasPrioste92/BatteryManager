package io.github.lucasprioste92.energydroid

import android.content.Context
import io.github.lucasprioste92.energydroid.data.broadcast_receiver.BatteryController
import io.github.lucasprioste92.energydroid.domain.model.BatteryData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

/**
 * Implementation of [BatteryObserver] that provides real-time observation of battery data.
 *
 * The [EnergyDroid] class allows you to observe battery data changes and fetch the latest
 * battery information from an Android device. It utilizes a [BroadcastReceiver] to listen
 * for battery-related events and emits updates through a [Flow].
 *
 * @property context The [Context] used to access system services and resources.
 * @constructor Creates an instance of [EnergyDroid] with the specified context.
 */
class EnergyDroid(
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