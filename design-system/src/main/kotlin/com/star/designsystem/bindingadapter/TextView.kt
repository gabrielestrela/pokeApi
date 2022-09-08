package com.star.designsystem.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:text")
fun TextView.configureText(text: String?) {
    text?.let { this.text = it }
}
