package com.star.pokedex.data.datasource

import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import com.star.network.api.NetworkApi
import com.star.pokedex.data.api.PokedexApi
import com.star.pokedex.data.response.PokedexListItemResponse

class PokedexRemoteDataSource(
    private val network: NetworkApi,
    private val apiService: PokedexApi
) : PokedexDataSource {
    override suspend fun fetchPokemonData(
        pokemonId: Int
    ): Result<ErrorData, PokedexListItemResponse> =
        network.executeSafe { apiService.getPokemon(pokemonId.toString()) }
}
