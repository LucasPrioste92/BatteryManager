package com.lucasprioste.batterymanager.di

import android.content.Context
import com.lucasprioste.batterymanager.core.battery_manager.BatteryObserver
import com.lucasprioste.batterymanager.core.battery_manager.BatteryObserverImp
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
    fun providesBatteryObserver(@ApplicationContext context: Context): BatteryObserver{
        return BatteryObserverImp(context = context)
    }

}