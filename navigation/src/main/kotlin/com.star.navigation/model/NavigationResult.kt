package com.star.navigation.model

sealed class NavigationResult {
    data class Error(val message: String) : NavigationResult()
    object Success : NavigationResult()
}
