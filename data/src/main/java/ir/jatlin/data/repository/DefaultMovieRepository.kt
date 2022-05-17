package ir.jatlin.data.repository

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.model.movie.MovieItem
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


class DefaultMovieRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher
) : MovieRepository {

    override suspend fun getMovieDetails(movieId: Long): MovieDetailsDTO {
        TODO("Not yet implemented")
    }

    override suspend fun getPopulars(page: Int): MoviesResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getUpcoming(page: Int): UpcomingMoviesResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getTopRated(page: Int): MoviesResponse {
        TODO("Not yet implemented")
    }

    override suspend fun discoverMovies(
        page: Int,
        sortBy: String?,
        filters: Map<String, String>?
    ): List<MovieItem> {
        TODO("Not yet implemented")
    }
}