package com.star.common_android.tools

import com.star.common_android.BuildConfig

fun runIfDebug(block: () -> Unit) {
    if (BuildConfig.DEBUG) block()
}
