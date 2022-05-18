package ir.jatlin.data.source.remote

import com.google.gson.Gson
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.di.CpuDispatcher
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class FakeMovieRemoteDataSource @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val gson: Gson
) : MovieRemoteDataSource {

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
    ): MoviesResponse {
        TODO("Not yet implemented")
    }
}