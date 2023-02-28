package com.example.everfittest.utils.scheduler

sealed class DataResult<out R> {

    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(val exception: Exception) : DataResult<Nothing>()
    object Loading : DataResult<Nothing>()

    inline fun executeIfFailed(block: (ex: Exception) -> Unit): DataResult<R> {
        if (this is Error) block(this.exception)
        return this
    }

    inline fun <M> map(block: (R) -> M): DataResult<M> {
        return when (this) {
            is Success -> Success(block(data))
            is Error -> Error(exception)
            is Loading -> Loading
        }
    }
}
