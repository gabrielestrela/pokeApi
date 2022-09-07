package com.star.pokedex.data.api

import com.star.common_kotlin.network.Service
import retrofit2.Retrofit

class AppPokedexApi(private val retrofit: Retrofit) : Service<PokedexApi> {
    override fun getService(): PokedexApi =
        retrofit.create(PokedexApi::class.java)
}
