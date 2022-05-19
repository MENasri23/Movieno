package ir.jatlin.data.repository

import ir.jatlin.core.data.repository.GenreRepository
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.data.repository.mapper.movie.asGenre
import ir.jatlin.model.movie.Genre
import ir.jatlin.webservice.model.movie.GenreDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DefaultGenreRepository @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val network: MovieRemoteDataSource
) : GenreRepository {

    private var genres: List<Genre>? = null
    private val mutex = Mutex()


    private suspend fun fetchGenresList() = network.getAllGenres().genres
        .map(GenreDTO::asGenre)
        .also {
            mutex.lock { genres = it }
        }

    override suspend fun getAllGenres(): List<Genre> = withContext(dispatcher) {
        genres ?: fetchGenresList()
    }

    override suspend fun getGenreById(id: Int): Genre? {
        val genres = genres ?: fetchGenresList()
        return genres.firstOrNull { it.id == id }
    }
}