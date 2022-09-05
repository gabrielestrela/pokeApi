package com.star.pokedex.data.repository

import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import com.star.pokedex.domain.model.PokedexListItemData

interface PokedexRepository {
    suspend fun getPokemonData(pokemonId: Int): Result<ErrorData, PokedexListItemData>
}
