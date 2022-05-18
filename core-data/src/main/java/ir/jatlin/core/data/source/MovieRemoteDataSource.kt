package ir.jatlin.core.data.source

import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.GenresResponse
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse

interface MovieRemoteDataSource {

    suspend fun getMovieDetails(movieId: Long): MovieDetailsDTO

    suspend fun getPopulars(page: Int): MoviesResponse

    suspend fun getUpcoming(page: Int): UpcomingMoviesResponse

    suspend fun getTopRated(page: Int): MoviesResponse

    suspend fun getAllGenres(): GenresResponse

    suspend fun discoverMovies(
        page: Int,
        sortBy: String? = null,
        filters: Map<String, String>? = null
    ) : MoviesResponse

}