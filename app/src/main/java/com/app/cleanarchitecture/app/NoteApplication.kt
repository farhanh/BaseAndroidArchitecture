package com.app.cleanarchitecture.app

import android.app.Application
import com.app.cleanarchitecture.di.DependencyInjectionEnvironment

/**
 * Created by Farhan on 10,March,2020
 */
class NoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DependencyInjectionEnvironment.init(this)
    }

}