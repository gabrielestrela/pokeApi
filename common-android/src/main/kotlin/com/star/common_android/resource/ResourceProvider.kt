package com.star.common_android.resource

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes resource: Int): String
    fun getString(@StringRes resource: Int, vararg args: String): String
    fun getColor(@ColorRes resource: Int, useCompat: Boolean = true): Int
    fun getDrawable(@DrawableRes resource: Int, useCompat: Boolean = true): Drawable?
}