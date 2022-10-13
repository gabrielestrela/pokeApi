package com.star.common_kotlin.tools

fun String.Companion.empty(): String = ""

fun Int.Companion.zero(): Int = 0

inline fun <T> T?.whenNull(block: () -> Unit) {
    if (this == null) block()
}