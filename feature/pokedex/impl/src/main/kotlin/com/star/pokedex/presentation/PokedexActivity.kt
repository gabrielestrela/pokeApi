package com.star.pokedex.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.star.navigation.constants.Transition
import com.star.navigation.core.Navigator
import com.star.navigation.extensions.addSlideTransition
import com.star.pokedex.di.POKEDEX_NAV
import com.star.pokedex.impl.R
import com.star.pokedex.impl.databinding.ActivityPokedexBinding
import com.star.pokedex.presentation.fragment.PokedexFragment
import com.star.pokedex.presentation.navigation.PokedexNavigator.Companion.POKEDEX_BACK_STACK
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class PokedexActivity : FragmentActivity() {

    private lateinit var binding: ActivityPokedexBinding

    private val navigator: Navigator by inject(named(POKEDEX_NAV))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pokedex)

        navigator.navigateToFragment(
            activity = this,
            transition = Transition.SLIDE
        )
    }
}
