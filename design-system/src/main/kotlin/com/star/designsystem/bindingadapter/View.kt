package com.star.designsystem.bindingadapter

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isPresent")
fun View.configureVisibility(isPresent: Boolean?) {
    isPresent?.let {
        this.isVisible = it
    }
}
