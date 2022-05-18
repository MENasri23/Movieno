package ir.jatlin.domain.result

sealed class ErrorCause {

    class Unknown(val throwable: Throwable? = null) : ErrorCause()

    class BadResponseCode(val responseCode: Int) : ErrorCause()

    object Parse : ErrorCause()

    object NoConnection : ErrorCause()

    object RefreshTokenFailed : ErrorCause()

    object NoContent : ErrorCause()

    object Internal : ErrorCause()

    object VerifyOtpFailed : ErrorCause()
    object NotFound : ErrorCause()
    object Forbidden : ErrorCause()
    object BadRequest : ErrorCause()
    object RequestTimeout : ErrorCause()

}