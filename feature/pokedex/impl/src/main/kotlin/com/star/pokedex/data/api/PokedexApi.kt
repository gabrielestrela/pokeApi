package com.star.pokedex.data.api

import com.star.pokedex.data.response.PokedexListItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApi {
    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") pokemonId: String
    ): PokedexListItemResponse
}
