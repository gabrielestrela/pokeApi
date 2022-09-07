package com.star.common_kotlin.tools

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun joinAll(vararg blocks: suspend () -> Unit) = coroutineScope {
    blocks.forEach { launch { it } }
}
