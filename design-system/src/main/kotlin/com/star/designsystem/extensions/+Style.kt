package com.star.designsystem.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun View.getColor(@ColorRes resource: Int) = ContextCompat.getColor(this.context, resource)

fun Fragment.getColor(@ColorRes resource: Int) = ContextCompat.getColor(requireContext(), resource)

fun Activity.getColor(@ColorRes resource: Int) = ContextCompat.getColor(this, resource)

fun Context.getColor(@ColorRes resource: Int) = ContextCompat.getColor(this, resource)

fun View.getDrawable(@DrawableRes resource: Int) = ContextCompat.getDrawable(this.context, resource)

fun Fragment.getDrawable(@DrawableRes resource: Int) =
    ContextCompat.getDrawable(requireContext(), resource)

fun Activity.getDrawable(@DrawableRes resource: Int) =
    ContextCompat.getDrawable(this, resource)

fun Context.getDrawable(@DrawableRes resource: Int) =
    ContextCompat.getDrawable(this, resource)