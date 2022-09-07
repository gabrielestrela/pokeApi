package com.star.pokedex.data.datasource.local

import com.star.common_android.cache.Cache
import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import com.star.pokedex.data.datasource.PokedexDataSource
import com.star.pokedex.data.response.PokedexListItemResponse

private const val INVALID_BY_POLICY_ERROR = "Data is expired by policy"

class PokedexLocalDataSource(
    private val pokedexCache: Cache<String, PokedexListItemResponse>
) : PokedexDataSource {
    override suspend fun fetchPokemonData(
        pokemonId: Int
    ): Result<ErrorData, PokedexListItemResponse> {
        val result = pokedexCache.getWithPolicies(
            "${PokedexCache.POKEMON_LIST_KEY}-${pokemonId}"
        )
        return if (result == null) {
            Result.Error(ErrorData.IoError(INVALID_BY_POLICY_ERROR))
        } else Result.Success(result)
    }

    override suspend fun savePokemonData(data: PokedexListItemResponse) {
        pokedexCache.set(
            key = "${PokedexCache.POKEMON_LIST_KEY}-${data.pokedexIndex}",
            value = data
        )
    }
}