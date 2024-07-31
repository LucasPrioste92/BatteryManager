package io.github.lucasprioste92.energydroid

import io.github.lucasprioste92.energydroid.domain.model.BatteryData
import kotlinx.coroutines.flow.Flow

/**
 * Interface for observing battery data on an Android device.
 *
 * The [BatteryObserver] interface provides methods to observe changes in the device's battery
 * status and retrieve the latest battery data. It allows developers to implement
 * reactive and coroutine-based handling of battery information.
 */
interface BatteryObserver {
    /**
     * Observes battery data changes and emits them as a [Flow] of [BatteryData].
     *
     * This function returns a [Flow] that emits [BatteryData] objects whenever the battery status
     * changes. It allows for reactive handling of battery data updates in a coroutine-based manner.
     *
     * @return A [Flow] emitting [BatteryData] objects with the latest battery information.
     * @see Flow
     * @see BatteryData
     */
    fun observe(): Flow<BatteryData>
    /**
     * Retrieves the latest [BatteryData].
     *
     * This function is a suspend function that fetches and returns the most recent
     * [BatteryData] available. It is designed to be called within a coroutine or another suspend function.
     *
     * @return The most recent [BatteryData] object.
     * @see BatteryData
     */
    suspend fun latestData(): BatteryData
}