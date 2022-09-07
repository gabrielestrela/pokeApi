package com.star.pokeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.star.navigation.constants.Transition
import com.star.navigation.core.Navigator
import com.star.pokeapi.databinding.ActivityMainBinding
import com.star.pokedex.di.POKEDEX_NAV
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pokedexNavigator: Navigator by inject(named(POKEDEX_NAV))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        pokedexNavigator.navigateToActivity(
            from = this,
            transition = Transition.FADE
        )
    }
}
