package com.example.mvvmnews

import android.app.Application
import com.example.mvvmnews.di.appModule
import com.example.mvvmnews.di.networkModule
import com.example.mvvmnews.di.repositoryModule
import com.example.mvvmnews.di.viewModuleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(arrayListOf(appModule, viewModuleModule, repositoryModule, networkModule))
        }
    }
}