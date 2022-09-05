package com.star.common_android.resource

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

class AppResourceProvider(
    private val context: Context
) : ResourceProvider {
    override fun getString(resource: Int): String = context.getString(resource)

    override fun getString(
        resource: Int,
        vararg args: String
    ): String = context.getString(resource, *args)

    override fun getColor(resource: Int, useCompat: Boolean): Int =
        if (useCompat) ContextCompat.getColor(context, resource) else context.getColor(resource)

    override fun getDrawable(resource: Int, useCompat: Boolean): Drawable? =
        if (useCompat) {
            ContextCompat.getDrawable(context, resource)
        } else context.getDrawable(resource)
}
