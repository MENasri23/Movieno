package ir.jatlin.core.data.repository

import ir.jatlin.model.movie.MovieItem
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse

interface MovieRepository {

    suspend fun getMovieDetails(movieId: Long): MovieDetailsDTO

    suspend fun getPopulars(page: Int): MoviesResponse

    suspend fun getUpcoming(page: Int): UpcomingMoviesResponse

    suspend fun getTopRated(page: Int): MoviesResponse

    suspend fun discoverMovies(
        page: Int,
        sortBy: String? = null,
        filters: Map<String, String>? = null
    ): List<MovieItem>

}