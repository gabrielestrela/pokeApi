package com.star.navigation.extensions

import androidx.fragment.app.FragmentTransaction
import com.star.navigation.R
import com.star.navigation.constants.Transition

fun FragmentTransaction.addTransition(transition: Transition): FragmentTransaction =
    when (transition) {
        Transition.FADE -> addFadeTransition()
        Transition.SLIDE -> addSlideTransition()
        else -> this
    }

fun FragmentTransaction.addSlideTransition(): FragmentTransaction =
    this.setCustomAnimations(
        R.anim.enter_from_right,
        R.anim.exit_to_left,
        R.anim.enter_from_left,
        R.anim.exit_to_right
    )

fun FragmentTransaction.addFadeTransition(): FragmentTransaction =
    this.setCustomAnimations(
        R.anim.fade_in,
        R.anim.fade_out,
        R.anim.fade_in,
        R.anim.fade_out,
    )

fun FragmentTransaction.shouldAddToBackStack(
    addToBackStack: Boolean,
    backStack: String
): FragmentTransaction =
    if (addToBackStack) this.addToBackStack(backStack) else this