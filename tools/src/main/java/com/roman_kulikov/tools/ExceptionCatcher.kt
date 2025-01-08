package com.roman_kulikov.tools

interface ExceptionCatcher {
    suspend fun <T> launchWithCatch(job: suspend () -> Result<T>): Result<T>
    fun <T> withCatch(job: () -> Result<T>): Result<T>
}