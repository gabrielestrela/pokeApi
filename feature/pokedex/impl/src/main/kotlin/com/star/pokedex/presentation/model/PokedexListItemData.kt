package com.star.pokedex.presentation.model

data class PokedexListItemData(
    @DrawableRes val backgroundDrawable: Int = 0,
    val pokedexNumberUi: PokedexNumberUiData = PokedexNumberUiData(),
    val pokemonName: String = "",
    val pokemonTypes: List<PokemonTypeUiData> = emptyList(),
    @DrawableRes val pokemonImage: Int = 0
)

data class PokedexNumberUiData(
    val pokedexNumber: String = "",
    @ColorRes val pokedexNumberColor: Int = 0,
)

data class PokemonTypeUiData(
    val type: PokemonType = PokemonType.NONE,
    @DrawableRes val chipBackground: Int = 0,
    val isVisible: Boolean = false
)

