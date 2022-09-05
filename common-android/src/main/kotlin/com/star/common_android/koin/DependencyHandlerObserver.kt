package com.star.common_android.koin

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

class DependencyHandlerObserver(private val dependencies: List<Module>) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        unloadKoinModules(dependencies)
        loadKoinModules(dependencies)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        unloadKoinModules(dependencies)
    }
}