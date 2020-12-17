package com.strider.unsplashphotoviewerapp

import android.app.Application
import com.chibatching.kotpref.Kotpref
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ImageViewerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Kotpref.init(this)
        Timber.plant(Timber.DebugTree())
    }
}