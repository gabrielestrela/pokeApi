package com.star.network.api

import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result

interface NetworkApi {
    suspend fun <R : Any> executeSafe(block: suspend () -> R): Result<ErrorData, R>
    suspend fun <R : Any> executeWithRetry(
        block: suspend () -> R,
        times: Int = 10,
        initialDelay: Long = 100,
        maxDelay: Long = 1000,
        factor: Double = 2.0,
    ): Result<ErrorData, R?>
}
