# Battery Manager
Application under development whose main objective is to obtain information regarding the Android device's battery using Google's BatteryManager library.

## Description
The objective of this project is to create a class, that using the clean architecture methodology, can be used in any part of the code that requires information related to the battery. This class will return a flow that contains the battery information. At this point the development of this class has already been completed and it is simple to use anywhere we need it. To consider this project complete, I still need to finish the layout, something that is not relevant to the main objective of this project, but at the moment I am facing a personal challenge of being able to develop a layout where the device's screen turns into an ocean and depending on the % battery level the water level either increases or decreases, something similar to this design (https://dev.to/exytehq/jetpack-compose-tutorial-replicating-the-water-level-widget-54hg).

## Technologies

* Kotlin
* Jetpack Compose
* Material3
* BatteryManager API
* Dagger Hilt

## Architecture

* MVVM with Clean approach
