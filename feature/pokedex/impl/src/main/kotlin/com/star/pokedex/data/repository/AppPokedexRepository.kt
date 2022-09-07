package com.star.pokedex.data.repository

import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import com.star.pokedex.data.datasource.PokedexDataSource
import com.star.pokedex.data.mapper.PokemonResponseToDomainData
import com.star.pokedex.domain.model.PokedexListItemData

class AppPokedexRepository(
    private val remoteDataSource: PokedexDataSource,
    private val localDataSource: PokedexDataSource,
    private val responseToDomainData: PokemonResponseToDomainData
) : PokedexRepository {
    override suspend fun getPokemonData(pokemonId: Int): Result<ErrorData, PokedexListItemData> =
        when (val result = remoteDataSource.fetchPokemonData(pokemonId)) {
            is Result.Success -> Result.Success(responseToDomainData.mapFrom(result.data))
            is Result.Error -> Result.Error(result.errorData)
        }
}
