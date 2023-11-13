package com.example.mymuscleapp

import android.app.Application
import com.example.mymuscleapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyMuscleApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyMuscleApp)
            modules(appModule)
        }
    }
}