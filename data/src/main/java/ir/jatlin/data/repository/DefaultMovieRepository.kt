package ir.jatlin.data.repository

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.model.movie.MovieItem
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DefaultMovieRepository @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val network: MovieRemoteDataSource,
) : MovieRepository {

    override  fun getMovieDetails(movieId: Long): Flow<MovieDetailsDTO> {
        TODO("Not yet implemented")
    }

    override  fun getPopulars(page: Int): Flow<MoviesResponse> {
        TODO("Not yet implemented")
    }

    override  fun getUpcoming(page: Int): Flow<UpcomingMoviesResponse> {
        TODO("Not yet implemented")
    }

    override  fun getTopRated(page: Int): Flow<MoviesResponse> {
        TODO("Not yet implemented")
    }

    override  fun discoverMovies(
        page: Int,
        sortBy: String?,
        filters: Map<String, String>?
    ): List<MovieItem> {
        TODO("Not yet implemented")
    }
}