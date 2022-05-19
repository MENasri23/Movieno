package ir.jatlin.core.shared.result.fail

interface ErrorHandler {
    fun handle(cause: Throwable): ErrorCause
}