package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.domain.FlowUseCase
import ir.jatlin.model.movie.info.MoviesInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUesCase @Inject constructor(
    private val movieRepository: MovieRepository
) : FlowUseCase<Int, MoviesInfo>() {

    override fun execute(params: Int): Flow<MoviesInfo> {
        return movieRepository.getPopulars(page = params)
    }
}