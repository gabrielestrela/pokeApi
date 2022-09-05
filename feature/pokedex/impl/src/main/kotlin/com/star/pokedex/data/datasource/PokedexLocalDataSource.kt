package com.star.pokedex.data.datasource

import com.star.common_android.cache.Cache
import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import com.star.pokedex.data.response.PokedexListItemResponse

class PokedexLocalDataSource(
    private val pokedexCache: Cache<String, List<PokedexListItemResponse>>
) : PokedexDataSource {
    override suspend fun fetchPokemonData(pokemonId: Int): Result<ErrorData, PokedexListItemResponse> {
        
    }

    override suspend fun savePokemonData(data: PokedexListItemResponse) {

    }
}