package com.balbasio.cryptoappjetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlin.text.Typography.dagger

@HiltAndroidApp
class CryptoCrazyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}