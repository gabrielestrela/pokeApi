package com.star.common_kotlin.tools

fun <T: Any, R: Any> Collection<T?>.runIfNoNulls(block: (List<T>)->R) {
    if (this.all { it != null })  block(this.filterNotNull())
}

fun <T: Any, R: Any> Collection<T?>.filterNullsAndExecute(block: (List<T>)->R) {
    if (this.any { it != null }) block(this.filterNotNull())
}

fun <T: Any, R: Any> runIfNoNulls(vararg options: T?, block: (List<T>)->R) {
    if (options.all { it != null }) {
        block(options.filterNotNull()) // or do unsafe cast to non null collection
    }
}

fun <T: Any, R: Any> filterNullsAndExecute(vararg options: T?, block: (List<T>)->R) {
    if (options.any { it != null }) {
        block(options.filterNotNull())
    }
}

fun <T: Any, R: Any> Collection<T?>.mapFirstNotNull(block: (T) -> R) {
    this.find { item -> item != null }?.let { block(it) }
}
