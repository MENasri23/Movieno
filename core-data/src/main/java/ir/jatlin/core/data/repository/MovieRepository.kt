package ir.jatlin.core.data.repository

import ir.jatlin.model.movie.MovieDetails
import ir.jatlin.model.movie.info.MoviesInfo
import ir.jatlin.model.movie.info.UpcomingMoviesInfo
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovieDetails(movieId: Long): Flow<MovieDetails>

    fun getPopulars(page: Int): Flow<MoviesInfo>

    fun getUpcoming(page: Int): Flow<UpcomingMoviesInfo>

    fun getTopRated(page: Int): Flow<MoviesInfo>

    suspend fun discoverMovies(
        page: Int,
        sortBy: String? = null,
        filters: Map<String, String>? = null
    ): MoviesInfo

}