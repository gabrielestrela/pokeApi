package com.star.navigation.core

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.star.navigation.constants.Transition
import com.star.navigation.model.NavigationResult

interface Navigator {
    fun navigateToActivity(
        from: Activity,
        transition: Transition = Transition.NONE
    ): NavigationResult

    fun navigateToFragment(
        activity: FragmentActivity,
        addToBackStack: Boolean = true,
        transition: Transition = Transition.NONE
    ): NavigationResult
}
