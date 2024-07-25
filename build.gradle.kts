// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.vanniktech.maven) apply false
}