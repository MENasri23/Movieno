package ir.jatlin.data.source.remote

import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.webservice.api.MovieApi
import ir.jatlin.webservice.api.SafeApiCall
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRetrofitDataSource @Inject constructor(
    private val networkApi: MovieApi,
    private val safeCall: SafeApiCall
) : MovieRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Long): MovieDetailsDTO {
        return safeCall { networkApi.getMovieDetails(movieId) }
    }

    override suspend fun getPopulars(page: Int): MoviesResponse {
        return safeCall { networkApi.getPopulars(page) }
    }

    override suspend fun getUpcoming(page: Int): UpcomingMoviesResponse {
        return safeCall { networkApi.getUpcoming(page) }
    }

    override suspend fun getTopRated(page: Int): MoviesResponse {
        return safeCall { networkApi.getTopRated(page) }
    }

    override suspend fun discoverMovies(
        page: Int,
        sortBy: String?,
        filters: Map<String, String>?
    ): MoviesResponse {
        return safeCall {
            networkApi.discoverMovies(
                page = page, sortBy = sortBy, filters = filters
            )
        }
    }

}