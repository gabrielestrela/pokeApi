package com.star.pokedex.domain.model

import com.star.common_kotlin.model.PokemonType
import com.star.common_kotlin.tools.empty

data class PokedexListItemData(
    val pokedexNumber: Int = 0,
    val pokemonName: String = String.empty(),
    val types: List<PokemonType> = listOf(),
)
