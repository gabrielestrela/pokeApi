package com.star.pokedex.data.datasource.remote

import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import com.star.common_kotlin.network.Service
import com.star.network.api.NetworkApi
import com.star.pokedex.data.api.AppPokedexApi
import com.star.pokedex.data.api.PokedexApi
import com.star.pokedex.data.datasource.PokedexDataSource
import com.star.pokedex.data.response.PokedexListItemResponse

class PokedexRemoteDataSource(
    private val network: NetworkApi,
    private val apiService: Service<PokedexApi>
) : PokedexDataSource {
    override suspend fun fetchPokemonData(
        pokemonId: Int
    ): Result<ErrorData, PokedexListItemResponse> =
        network.executeSafe {
            apiService
                .getService()
                .getPokemon(pokemonId.toString())
        }
}
