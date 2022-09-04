package com.star.network.api

import com.star.common_kotlin.network.ErrorData
import com.star.common_kotlin.network.Result
import kotlinx.coroutines.delay
import okhttp3.internal.http2.ConnectionShutdownException
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.UnknownHostException


class AppNetwork : NetworkApi {
    override suspend fun <R : Any> executeSafe(block: suspend () -> R): Result<ErrorData, R> =
        try {
            parseSuccessResponse(block())
        } catch(e: Exception) {
            when (e) {
                is HttpException -> Result.Error(ErrorData.HttpError(e.code(), e.message()))
                else -> Result.Error(
                    ErrorData.NetworkError(
                        message = e.message,
                        isConnectionError = e.isConnectionException()
                    )
                )
            }
        }

    override suspend fun <R : Any> executeWithRetry(
        block: suspend () -> R,
        times: Int,
        initialDelay: Long,
        maxDelay: Long,
        factor: Double
    ): Result<ErrorData, R?> {
        var currentDelay = initialDelay
        repeat(times - 1) {
            val response = executeSafe { block() }
            when {
                response.isSuccess -> return response
                else -> {
                    delay(currentDelay)
                    currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
                }
            }
        }
        return executeSafe(block)
    }

    private fun <S : Any> parseSuccessResponse(response: S): Result<ErrorData, S> =
        if (response !is Response<*>) Result.Success(response)
        else {
            if (response.isSuccessful) Result.Success(response)
            else {
                Result.Error(ErrorData.HttpError(response.code(), response.message()))
            }
        }

    private fun Throwable.isConnectionException(): Boolean =
        this is ConnectException ||
                this is UnknownHostException ||
                this is ConnectionShutdownException
}
