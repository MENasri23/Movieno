package ir.jatlin.domain

import ir.jatlin.core.shared.result.Resource
import ir.jatlin.core.shared.result.fail.ErrorHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart


abstract class FlowUseCase<P, R>(
    private val errorHandler: ErrorHandler,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    operator fun invoke(params: P): Flow<Resource<R>> = execute(params)
        .map {
            Resource.success(it)
        }
        .onStart {
            emit(Resource.loading())
        }
        .catch { cause ->
            val errorCause = errorHandler.handle(cause)
            emit(Resource.error(errorCause))
        }


    protected abstract fun execute(params: P): Flow<R>
}