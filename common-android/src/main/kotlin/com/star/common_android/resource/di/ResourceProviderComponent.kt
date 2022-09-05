package com.star.common_android.resource.di

import com.star.common_android.resource.AppResourceProvider
import com.star.common_android.resource.ResourceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val resourceProviderModule = module {
    single<ResourceProvider> { AppResourceProvider(androidContext()) }
}
