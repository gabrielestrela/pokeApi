package com.star.pokedex.presentation.viewmodel.viewstate

import com.star.common_android.viewmodel.viewstate.State
import com.star.pokedex.presentation.model.PokedexListItemUi

data class PokedexViewState(
    val pokedexList: List<PokedexListItemUi> = listOf()
) : State