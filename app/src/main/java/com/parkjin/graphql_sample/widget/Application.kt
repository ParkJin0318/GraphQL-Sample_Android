package com.parkjin.graphql_sample.widget

import android.app.Application
import com.parkjin.graphql_sample.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            val modules = listOf(viewModelModule, networkModule, repositoryModule)
            modules(modules)
        }
    }
}