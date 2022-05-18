package ir.jatlin.domain

import ir.jatlin.core.shared.result.Resource
import ir.jatlin.core.shared.result.fail.ErrorCause
import ir.jatlin.data.source.remote.NetworkException
import ir.jatlin.data.source.remote.NoBodyException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import java.io.IOException
import java.net.SocketTimeoutException

typealias StatusCode = ErrorCause.StatusCode

abstract class FlowUseCase<P, R> {

    suspend operator fun invoke(params: P): Flow<Resource<R>> = execute(params)
        .map {
            Resource.success(it)
        }
        .onStart {
            emit(Resource.loading())
        }
        .catch { cause ->
            val errorCause = handleException(cause)
            emit(Resource.error(errorCause))
        }

    private fun handleException(cause: Throwable) = when (cause) {
        is NoBodyException -> ErrorCause.NoContent
        is NetworkException -> {
            val networkError = cause.error
            with(StatusCode) {
                when (val code = networkError.code) {
                    BAD_REQUEST -> ErrorCause.BadRequest
                    FORBIDDEN -> ErrorCause.Forbidden
                    NOT_FOUND -> ErrorCause.NotFound
                    REQUEST_TIMEOUT -> ErrorCause.RequestTimeout
                    VERIFY_OTP_FAILED -> ErrorCause.VerifyOtpFailed
                    else -> ErrorCause.BadResponseCode(code)
                }
            }
        }
        is SocketTimeoutException -> ErrorCause.RequestTimeout
        is IOException -> ErrorCause.Internal
        else -> ErrorCause.Unknown(cause)
    }

    abstract fun execute(params: P): Flow<R>
}