package ir.jatlin.data.source.fake

import com.google.gson.Gson
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.webservice.ResourceProvider
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.GenresResponse
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FakeMovieRemoteDataSource @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val gson: Gson
) : MovieRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Long): MovieDetailsDTO {
        return withContext(dispatcher) {
            gson.fromJson(
                ResourceProvider.readFrom("movie-detail-response.json"),
                MovieDetailsDTO::class.java
            )
        }
    }

    override suspend fun getPopulars(page: Int): MoviesResponse = withContext(dispatcher) {
        gson.fromJson(
            ResourceProvider.readFrom("popular-movie-response.json"),
            MoviesResponse::class.java
        )
    }

    override suspend fun getUpcoming(page: Int): UpcomingMoviesResponse = withContext(dispatcher) {
        gson.fromJson(
            ResourceProvider.readFrom("upcoming-response.json"),
            UpcomingMoviesResponse::class.java
        )
    }

    override suspend fun getTopRated(page: Int): MoviesResponse = withContext(dispatcher) {
        gson.fromJson(
            ResourceProvider.readFrom("top-rated-movie-response.json"),
            MoviesResponse::class.java
        )
    }

    override suspend fun getAllGenres(): GenresResponse = withContext(dispatcher) {
        gson.fromJson(
            ResourceProvider.readFrom("genres-response.json"),
            GenresResponse::class.java
        )
    }

    override suspend fun discoverMovies(
        page: Int,
        sortBy: String?,
        filters: Map<String, String>?
    ): MoviesResponse = withContext(dispatcher) {
        gson.fromJson(
            ResourceProvider.readFrom("discover-movie-response.json"),
            MoviesResponse::class.java
        )
    }
}