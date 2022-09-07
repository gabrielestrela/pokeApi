package com.star.pokedex.presentation.viewmodel

import com.star.common_android.viewmodel.ViewModel
import com.star.pokedex.presentation.viewmodel.sideeffect.PokedexSideEffect
import com.star.pokedex.presentation.viewmodel.viewprocedure.PokedexViewProcedure
import com.star.pokedex.presentation.viewmodel.viewstate.PokedexViewState

class PokedexViewModel() : ViewModel<PokedexViewState, PokedexViewProcedure, PokedexSideEffect>(PokedexViewState()) {

    init {

    }

    override fun executeViewProcedure(procedure: PokedexViewProcedure) {

    }
}