buildscript {
    val kotlinVersion: String by project
    println(kotlinVersion)

    val hilt_version = "2.37"
    val nav_version = "2.3.5"
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        // keeping this here to allow AS to automatically update
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${kotlinVersion}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath ("com.google.gms:google-services:4.3.10")
    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}