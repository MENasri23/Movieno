package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.core.shared.result.fail.ErrorHandler
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.domain.FlowUseCase
import ir.jatlin.model.movie.info.MoviesInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUesCase @Inject constructor(
    private val movieRepository: MovieRepository,
    errorHandler: ErrorHandler,
    @IODispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<Int, MoviesInfo>(errorHandler, dispatcher) {

    override fun execute(params: Int): Flow<MoviesInfo> {
        return movieRepository.getPopulars(page = params)
    }
}