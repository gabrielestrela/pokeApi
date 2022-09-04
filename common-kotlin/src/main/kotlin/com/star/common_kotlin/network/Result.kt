package com.star.common_kotlin.network

sealed class Result<out E, out S> {
    data class Error<out E>(val errorData: E) : Result<E, Nothing>()
    data class Success<out S>(val data: S) : Result<Nothing, S>()

    val isSuccess: Boolean
        get() = this is Success<S>

    val isError: Boolean
        get() = this is Error<E>

    fun <E> makeError(errorData: E) = Error(errorData)

    fun <S> makeSuccess(data: S) = Success(data)

    fun execute(
        onError: (E) -> Any,
        onSuccess: (S) -> Any,
    ): Any = when (this) {
        is Error -> onError(errorData)
        is Success -> onSuccess(data)
    }

    suspend fun executeAsync(
        onError: suspend (E) -> Any,
        onSuccess: suspend (S) -> Any,
    ) : Any = when (this) {
        is Error -> onError(errorData)
        is Success -> onSuccess(data)
    }
}
