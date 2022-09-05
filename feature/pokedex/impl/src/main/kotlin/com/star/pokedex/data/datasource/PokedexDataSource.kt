package com.star.pokedex.data.datasource

import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import com.star.pokedex.data.response.PokedexListItemResponse

interface PokedexDataSource {
    suspend fun fetchPokemonData(pokemonId: Int): Result<ErrorData, PokedexListItemResponse>
    suspend fun savePokemonData(data: PokedexListItemResponse) {}
}
