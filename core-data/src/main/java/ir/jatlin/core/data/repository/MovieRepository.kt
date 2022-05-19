package ir.jatlin.core.data.repository

import ir.jatlin.model.movie.MovieDetails
import ir.jatlin.model.info.MoviesInfo
import ir.jatlin.model.info.UpcomingMoviesInfo
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovieDetails(movieId: Long): Flow<MovieDetails>

    fun getPopulars(page: Int): Flow<MoviesInfo>

    fun getUpcoming(page: Int): Flow<UpcomingMoviesInfo>

    fun getTopRated(page: Int): Flow<MoviesInfo>

    fun discoverMovies(
        page: Int,
        sortBy: String? = null,
        filters: Map<String, String>? = null
    ): Flow<MoviesInfo>

}