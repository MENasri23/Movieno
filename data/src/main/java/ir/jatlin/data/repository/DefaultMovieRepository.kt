package ir.jatlin.data.repository

import ir.jatlin.core.data.repository.GenreRepository
import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.data.repository.mapper.movie.asMovieDetails
import ir.jatlin.data.repository.mapper.movie.asMovieItem
import ir.jatlin.data.repository.mapper.response.asExternalModel
import ir.jatlin.model.movie.MovieDetails
import ir.jatlin.model.info.MoviesInfo
import ir.jatlin.model.info.UpcomingMoviesInfo
import ir.jatlin.webservice.model.movie.MovieDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class DefaultMovieRepository @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val network: MovieRemoteDataSource,
    private val genreRepository: GenreRepository
) : MovieRepository {

    override fun getMovieDetails(movieId: Long): Flow<MovieDetails> = flow {
        emit(network.getMovieDetails(movieId).asMovieDetails())
    }

    override fun getPopulars(page: Int): Flow<MoviesInfo> = flow {
        emit(network.getPopulars(page).asExternalModel())
    }

    override fun getUpcoming(page: Int): Flow<UpcomingMoviesInfo> = flow {
        emit(network.getUpcoming(page).asExternalModel())
    }

    override fun getTopRated(page: Int): Flow<MoviesInfo> = flow {
        emit(network.getTopRated(page).asExternalModel())
    }

    override fun discoverMovies(
        page: Int,
        sortBy: String?,
        filters: Map<String, String>?
    ): Flow<MoviesInfo> = flow {
        emit(network.discoverMovies(page, sortBy, filters).asExternalModel())
    }

    private suspend fun UpcomingMoviesResponse.asExternalModel() = UpcomingMoviesInfo(
        start = dates.start,
        end = dates.end,
        moviesInfo = moviesResponse.asExternalModel()
    )

    private suspend fun MoviesResponse.asExternalModel() =
        asExternalModel(movieList.asMovieItems())

    private suspend fun List<MovieDTO>.asMovieItems() =
        map { networkMovie ->
            val genres = networkMovie.genreIds
                .mapNotNull { genreId -> genreRepository.getGenreById(genreId) }
            networkMovie.asMovieItem(genres)
        }
}