package com.lucasprioste.energydroid.data.broadcast_receiver

import com.lucasprioste.energydroid.domain.model.BatteryData

interface BatteryListener {
    fun change(data: BatteryData)
}