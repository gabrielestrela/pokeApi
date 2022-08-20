package com.star.pokeapi.tools

import com.star.pokeapi.BuildConfig

inline fun runIfDebug(block: () -> Unit) {
    if (BuildConfig.DEBUG) block()
}