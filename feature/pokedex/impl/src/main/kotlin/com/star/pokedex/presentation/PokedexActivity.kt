package com.star.pokedex.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleObserver
import com.star.common_android.koin.DependencyHandlerObserver
import com.star.navigation.constants.Transition
import com.star.navigation.core.Navigator
import com.star.pokedex.di.POKEDEX_NAV
import com.star.pokedex.di.pokedexModule
import com.star.pokedex.impl.R
import com.star.pokedex.impl.databinding.ActivityPokedexBinding
import com.star.pokedex.presentation.fragment.PokedexFragment
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class PokedexActivity :
    FragmentActivity(),
    LifecycleObserver by DependencyHandlerObserver(listOf(pokedexModule))  {

    private lateinit var binding: ActivityPokedexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pokedex)
    }
}
