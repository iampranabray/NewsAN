package com.djupbyte.newsan
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NiaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}