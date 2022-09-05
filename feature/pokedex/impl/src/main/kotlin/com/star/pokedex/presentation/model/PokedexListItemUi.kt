package com.star.pokedex.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.star.common_kotlin.model.PokemonType

data class PokedexListItemUi(
    @DrawableRes val backgroundDrawable: Int = 0,
    val pokedexNumberUi: PokedexNumberUi = PokedexNumberUi(),
    val pokemonName: String = "",
    val pokemonTypes: List<PokemonTypeUi> = emptyList(),
    @DrawableRes val pokemonImage: Int = 0
)

data class PokedexNumberUi(
    val pokedexNumber: String = "",
    @ColorRes val pokedexNumberColor: Int = 0,
)

data class PokemonTypeUi(
    val type: PokemonType = PokemonType.NONE,
    @DrawableRes val chipBackground: Int = 0,
    val isVisible: Boolean = false
)
