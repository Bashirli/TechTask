package com.bashirli.techtask.common

sealed class Resource<out T> {
    data class Success<out T>(val result: T?) : Resource<T>()
    data class Error(val throwable: Throwable) : Resource<Nothing>()
}