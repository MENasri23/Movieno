package ir.jatlin.core.data.repository

import ir.jatlin.model.movie.MovieItem
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovieDetails(movieId: Long): Flow<MovieDetailsDTO>

    fun getPopulars(page: Int): Flow<MoviesResponse>

    fun getUpcoming(page: Int): Flow<UpcomingMoviesResponse>

    fun getTopRated(page: Int): Flow<MoviesResponse>

    fun discoverMovies(
        page: Int,
        sortBy: String? = null,
        filters: Map<String, String>? = null
    ): List<MovieItem>

}