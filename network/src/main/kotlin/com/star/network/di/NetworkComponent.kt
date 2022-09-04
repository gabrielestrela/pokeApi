package com.star.network.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.star.network.api.AppNetwork
import com.star.network.api.NetworkApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val HTTP_LOGGING_INTERCEPTOR = "HttpLoggingInterceptor"
private const val MOSHI_CONVERTER_FACTORY = "MoshiConverterFactory"
private const val OKHTTP_CLIENT = "OkHttpClient"
private const val BASE_URL = "https://pokeapi.co/api/v2/"

val networkBaseModule = module {
    single(named(HTTP_LOGGING_INTERCEPTOR)) {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single(named(MOSHI_CONVERTER_FACTORY)) {
        Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    single {
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor = get(named(HTTP_LOGGING_INTERCEPTOR)))
            .build()
    }

    single {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get(named(MOSHI_CONVERTER_FACTORY))))
            .client(get(named(OKHTTP_CLIENT)))
            .build()
    }
}

val networkApiModule = module {
    factory<NetworkApi> { AppNetwork() }
}
