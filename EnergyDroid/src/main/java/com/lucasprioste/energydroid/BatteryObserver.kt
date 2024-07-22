package com.lucasprioste.energydroid

import com.lucasprioste.energydroid.domain.model.BatteryData
import kotlinx.coroutines.flow.Flow

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
    suspend fun latestData(): BatteryData
}