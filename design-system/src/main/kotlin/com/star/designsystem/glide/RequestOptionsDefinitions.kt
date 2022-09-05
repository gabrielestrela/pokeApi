package com.star.designsystem.glide

import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions

fun RequestOptions.setDefaultOption(): RequestOptions = this.apply {
    centerCrop()
    format(DecodeFormat.PREFER_ARGB_8888)
    disallowHardwareConfig()
    skipMemoryCache(false)
}