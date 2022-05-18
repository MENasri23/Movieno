package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.domain.FlowUseCase
import ir.jatlin.model.movie.MovieDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetails @Inject constructor(
    private val movieRepository: MovieRepository
) : FlowUseCase<GetMovieDetails.Params, MovieDetails>() {

    override fun execute(params: Params): Flow<MovieDetails> {
        return movieRepository.getMovieDetails(params.movieId)
    }

    data class Params(
        val movieId: Long
    )
}