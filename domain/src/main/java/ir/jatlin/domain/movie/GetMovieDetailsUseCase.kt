package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.core.shared.result.fail.ErrorHandler
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.domain.FlowUseCase
import ir.jatlin.model.movie.MovieDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    errorHandler: ErrorHandler,
    @IODispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<GetMovieDetailsUseCase.Params, MovieDetails>(errorHandler, dispatcher) {

    override fun execute(params: Params): Flow<MovieDetails> {
        return movieRepository.getMovieDetails(params.movieId)
    }

    data class Params(
        val movieId: Long
    )
}