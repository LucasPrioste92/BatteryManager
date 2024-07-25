package com.lucasprioste.batterymanager.di

import android.content.Context
import io.github.lucasprioste92.energydroid.BatteryObserver
import io.github.lucasprioste92.energydroid.EnergyDroid
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesBatteryObserver(@ApplicationContext context: Context): BatteryObserver {
        return EnergyDroid(context = context)
    }

}