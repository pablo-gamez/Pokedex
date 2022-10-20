package es.pagamez.pokedex.data.remote

import retrofit2.HttpException
import retrofit2.Response

inline fun <T> apiCall(call: () -> Response<T>): Result<T> {
    return try {
        val response = call.invoke()
        when {
            response.isSuccessful && response.body() != null -> Result.success(
                requireNotNull(response.body())
            )
            else -> Result.failure(HttpException(response))
        }
    } catch (exception: Exception) {
        Result.failure(exception)
    }
}