# EnergyDroid
Library whose main objective is to obtain information regarding the Android device's battery using Google's BatteryManager library.

## Description
This library is responsible for observing the battery of an Android device by utilizing the native BatteryManager library. The library provides two functions: one to observe the battery in real-time through a flow and another function that returns the current battery information only once. With this library, it becomes easier to obtain this data, as you only need to initialize the EnergyDroid class and start consuming the data. If you want to gain a deeper understanding of how the library works, I recommend checking out the post I published on Medium. Enjoy!

# Setup
## Download

EnergyDroid is available on `mavenCentral()`.

```kotlin
implementation("io.github.lucasprioste92:energydroid:0.1.1")
```

## Project Under API 26

Projects that support an API below 26 need to perform this step to enable `isCoreLibraryDesugaringEnabled`.

```kotlin
android {
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
}
```

# Quick Start
## Initialization

```kotlin
val energy = EnergyDroid(context = context)
```

## Observe Real Time Battery Data

```kotlin
energy.observe().collect{ data ->
    Log.i("EnergyDroid", data.level.toString())
}
```

## Observe One Time Battery Data

```kotlin
val data = batteryObserver.latestData()
```

Check out a [sample](https://github.com/LucasPrioste92/EnergyDroid/blob/main/app/src/main/java/com/lucasprioste/batterymanager/di/AppModule.kt) with EnergyDroid and Dagger Hilt.
