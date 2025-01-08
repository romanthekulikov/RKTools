package com.roman_kulikov.tools

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure<T>(val cause: String) : Result<T>()
    class NoNetwork<T> : Result<T>()
}