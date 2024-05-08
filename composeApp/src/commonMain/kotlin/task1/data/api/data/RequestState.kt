package task1.data.api.data

sealed class RequestState<out T> {
    data object Loading : RequestState<Nothing>()

    data object Init : RequestState<Nothing>()

    data class Success<T>(val data: T) : RequestState<T>()

    data class Error(val message: String) : RequestState<Nothing>()

    fun isLoading() = this is Loading

    fun isSuccess() = this is Success

    fun isError() = this is Error

    fun getSuccessData() = (this as Success).data

    fun getSuccessDataOrNull(): T? {
        return try {
            (this as Success).data
        } catch (e: Exception) {
            null
        }
    }

    fun getErrorMessage() = (this as Error).message
}
