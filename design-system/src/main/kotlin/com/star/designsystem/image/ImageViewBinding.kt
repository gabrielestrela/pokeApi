package com.star.designsystem.image

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.star.designsystem.glide.GlideApp

@BindingAdapter("url")
fun ImageView.setImage(url: String?) {
    url?.let {
        GlideApp.with(context).load(it).into(this)
    }
}
