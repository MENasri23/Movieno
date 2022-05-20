package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.core.shared.result.fail.ErrorHandler
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.domain.CoroutineUseCase
import ir.jatlin.domain.movie.filter.MovieParameters
import ir.jatlin.model.movie.info.MoviesInfo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DiscoverMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    errorHandler: ErrorHandler,
    @IODispatcher dispatcher: CoroutineDispatcher
) : CoroutineUseCase<MovieParameters, MoviesInfo>(errorHandler, dispatcher) {

    override suspend fun execute(params: MovieParameters): MoviesInfo {
        return movieRepository.discoverMovies(
            page = params.page,
            sortBy = params.sortBy,
            filters = params.filters
        )
    }

}