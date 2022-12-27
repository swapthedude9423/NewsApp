package com.lastmile.wanicity

import android.app.Application
import com.lastmile.wanicity.data.repository.repoModule
import com.lastmile.wanicity.di.module.appModule
import com.lastmile.wanicity.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}