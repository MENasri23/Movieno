package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.domain.FlowUseCase
import ir.jatlin.model.movie.info.UpcomingMoviesInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUpcomingMoviesUesCase @Inject constructor(
    private val movieRepository: MovieRepository
) : FlowUseCase<Int, UpcomingMoviesInfo>() {

    override fun execute(params: Int): Flow<UpcomingMoviesInfo> {
        return movieRepository.getUpcoming(page = params)
    }
}