package com.star.navigation.core

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.star.navigation.constants.Transition
import com.star.navigation.model.NavigationResult

interface Navigator {
    fun navigateToActivity(
        from: Activity,
        to: Activity,
        transition: Transition = Transition.NONE
    ): NavigationResult

    fun navigateToFragment(
        from: FragmentActivity,
        to: Fragment,
        @IdRes containerId: Int,
        addToBackStack: Boolean = true,
        transition: Transition = Transition.NONE
    ): NavigationResult
}
