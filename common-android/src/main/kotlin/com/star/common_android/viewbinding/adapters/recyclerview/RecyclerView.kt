package com.star.common_android.viewbinding.adapters.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("content")
fun <D> RecyclerView.setContent(previousContent: D?, content: D?) {
    val shouldProceed =
        content != null &&
                content != previousContent &&
                adapter is BindableRecyclerAdapter<*>

    if (shouldProceed) {
        content?.let {
            (adapter as BindableRecyclerAdapter<D>).setContent(it)
        }
    }
}
