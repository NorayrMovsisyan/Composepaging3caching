package com.example.composepaging3caching

import android.app.Application
import com.example.composepaging3caching.di.AppModule
import com.example.composepaging3caching.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BeerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BeerApp)
            modules(listOf(AppModule, ViewModelModule))
        }
    }
}