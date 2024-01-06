package io.graduation.haui

import android.app.Application
import android.content.Context

import dagger.hilt.android.HiltAndroidApp
import io.graduation.haui.utils.SharedPreferences

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferences.init(this)
    }
}