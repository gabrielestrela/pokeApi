package com.star.pokeapi.app

import android.app.Application
import com.star.common_android.resource.di.resourceProviderModule
import com.star.network.di.networkBaseModule
import com.star.pokeapi.tools.runIfDebug
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import timber.log.Timber

class PokeApiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startTimber()
        startKoin()
    }

    private fun startTimber() {
        runIfDebug { Timber.plant(Timber.DebugTree()) }
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@PokeApiApp)
            modules(getAppModules())
        }
    }

    private fun getAppModules(): List<Module> = listOf(
        networkBaseModule,
        resourceProviderModule
    )
}
