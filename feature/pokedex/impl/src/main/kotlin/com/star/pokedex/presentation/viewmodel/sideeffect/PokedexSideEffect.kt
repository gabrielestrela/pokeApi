package com.star.pokedex.presentation.viewmodel.sideeffect

import com.star.common_android.viewmodel.sideeffect.SideEffect

sealed class PokedexSideEffect : SideEffect {
    object NavigateToPokemonDetailScreen : PokedexSideEffect()
}