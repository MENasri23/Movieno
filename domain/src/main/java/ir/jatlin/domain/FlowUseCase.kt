package ir.jatlin.domain

import ir.jatlin.domain.result.ErrorCause
import ir.jatlin.domain.result.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

abstract class FlowUseCase<P, R> {

    suspend operator fun invoke(params: P): Flow<Resource<R>> = execute(params)
        .map { Resource.success(it) }
        .onStart { emit(Resource.loading()) }
        .catch { cause ->
            // emit appropriate error api
            emit(Resource.error(ErrorCause.NotFound))
        }

    abstract fun execute(params: P): Flow<R>
}