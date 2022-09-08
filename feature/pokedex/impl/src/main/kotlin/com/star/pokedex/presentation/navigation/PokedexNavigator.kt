package com.star.pokedex.presentation.navigation

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.star.common_android.tools.runIfDebug
import com.star.navigation.constants.Transition
import com.star.navigation.core.Navigator
import com.star.navigation.extensions.addTransition
import com.star.navigation.extensions.shouldAddToBackStack
import com.star.navigation.model.NavigationResult
import timber.log.Timber
import java.lang.IllegalArgumentException

class PokedexNavigator(
    private val context: Context
) : Navigator {
    override fun navigateToActivity(
        from: Activity,
        to: Activity,
        transition: Transition
    ): NavigationResult = try {
        from.startActivity(
            Intent(
                from.applicationContext,
                to::class.java,
            )
        )
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
        NavigationResult.Success
    } catch (e: ActivityNotFoundException) {
        val message = e.message.orEmpty()
        runIfDebug { Timber.e(message) }
        NavigationResult.Error(message)
    }

    override fun navigateToFragment(
        from: FragmentActivity,
        to: Fragment,
        containerId: Int,
        addToBackStack: Boolean,
        transition: Transition
    ): NavigationResult = try {
        from.supportFragmentManager
            .beginTransaction()
            .addTransition(transition)
            .shouldAddToBackStack(addToBackStack, POKEDEX_BACK_STACK)
            .replace(containerId, to)
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