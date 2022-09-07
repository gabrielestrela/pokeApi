package com.star.pokedex.presentation.navigation

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.star.common_android.tools.runIfDebug
import com.star.navigation.constants.Transition
import com.star.navigation.core.Navigator
import com.star.navigation.extensions.addTransition
import com.star.navigation.extensions.shouldAddToBackStack
import com.star.navigation.model.NavigationResult
import com.star.pokedex.impl.R
import com.star.pokedex.presentation.PokedexActivity
import com.star.pokedex.presentation.fragment.PokedexFragment
import timber.log.Timber
import java.lang.IllegalArgumentException

class PokedexNavigator(
    private val context: Context
) : Navigator {
    override fun navigateToActivity(
        from: Activity,
        transition: Transition
    ): NavigationResult = try {
        from.startActivity(
            Intent(
                from.applicationContext,
                PokedexActivity::class.java,
            )
        ).also {
            when (transition) {
                Transition.NONE -> {}
                Transition.FADE -> from.overridePendingTransition(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out,
                )
                Transition.SLIDE -> from.overridePendingTransition(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
            }
        }
        NavigationResult.Success
    } catch (e: ActivityNotFoundException) {
        val message = e.message.orEmpty()
        runIfDebug { Timber.e(message) }
        NavigationResult.Error(message)
    }

    override fun navigateToFragment(
        activity: FragmentActivity,
        addToBackStack: Boolean,
        transition: Transition
    ): NavigationResult = try {
        activity.supportFragmentManager
            .beginTransaction()
            .addTransition(transition)
            .shouldAddToBackStack(addToBackStack, POKEDEX_BACK_STACK)
            .replace(R.id.pokedex_fragment_container, PokedexFragment::class.java, null)
            .commit()
        NavigationResult.Success
    } catch (e: IllegalArgumentException) {
        val message = e.message.orEmpty()
        runIfDebug { Timber.e(message) }
        NavigationResult.Error(message)
    }

    companion object {
        const val POKEDEX_BACK_STACK = "POKEDEX_B_S"
    }
}