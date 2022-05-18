package ir.jatlin.data.repository

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.data.repository.mapper.movie.asMovieDetails
import ir.jatlin.model.movie.MovieDetails
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class DefaultMovieRepository @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val network: MovieRemoteDataSource,
) : MovieRepository {

    override fun getMovieDetails(movieId: Long): Flow<MovieDetails> = flow {
        emit(network.getMovieDetails(movieId).asMovieDetails())
    }

    override fun getPopulars(page: Int): Flow<MoviesResponse> = flow {
        emit(network.getPopulars(page))
    }

    override fun getUpcoming(page: Int): Flow<UpcomingMoviesResponse> = flow {
        emit(network.getUpcoming(page))
    }

    override fun getTopRated(page: Int): Flow<MoviesResponse> = flow {
        emit(network.getTopRated(page))
    }

    override fun discoverMovies(
        page: Int,
        sortBy: String?,
        filters: Map<String, String>?
    ): Flow<MoviesResponse> = flow {
        emit(network.discoverMovies(page, sortBy, filters))
    }
}