package com.app.cleanarchitecture.app

import android.app.Application
import com.app.cleanarchitecture.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * Created by Farhan on 10,March,2020
 */
@HiltAndroidApp
class NoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

}