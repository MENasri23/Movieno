package ir.jatlin.webservice.api

import com.google.gson.Gson
import ir.jatlin.webservice.model.response.NetworkError
import retrofit2.Response
import javax.inject.Inject

class SafeApiCall @Inject constructor(
    private val gson: Gson
) {

    @Throws()
    operator fun <T> invoke(
        response: Response<T>
    ): T {
        return if (response.isSuccessful) {
            val body = response.body()
            when {
                response.code() == 200 && body != null -> body
                body == null -> throw NoBodyException()
                else -> throw Exception()
            }
        } else {
            val errorBody = response.errorBody()
            val networkError = gson.fromJson(errorBody?.charStream(), NetworkError::class.java)

            throw NetworkException(error = networkError)
        }
    }

}


class NoBodyException(msg: String? = null) : Exception(msg)

class NetworkException(val error: NetworkError, msg: String? = null) : Exception(msg)
