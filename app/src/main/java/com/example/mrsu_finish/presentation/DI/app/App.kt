package com.example.mrsu_finish.presentation.DI.app

import android.app.Application
import com.example.mrsu_finish.presentation.DI.appModule
import com.example.mrsu_finish.presentation.DI.dataModule
import com.example.mrsu_finish.presentation.DI.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}