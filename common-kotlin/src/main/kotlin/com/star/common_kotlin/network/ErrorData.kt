package com.star.common_kotlin.network

sealed class ErrorData{
    data class HttpError(
        val code: Int? = null,
        val message: String = ""
    ) : ErrorData()

    data class IoError(val message: String = "") : ErrorData()

    data class NetworkError(
        val message: String? = "",
        val isConnectionError: Boolean
    ) : ErrorData()

    object GenericError : ErrorData()
}
