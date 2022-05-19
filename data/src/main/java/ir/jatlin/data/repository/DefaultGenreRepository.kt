package ir.jatlin.data.repository

import ir.jatlin.core.data.repository.GenreRepository
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.data.repository.mapper.movie.asGenre
import ir.jatlin.model.movie.Genre
import ir.jatlin.webservice.model.movie.GenreDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DefaultGenreRepository @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val network: MovieRemoteDataSource
) : GenreRepository {

    override suspend fun getAllGenres(): List<Genre> = withContext(dispatcher) {
        val response = network.getAllGenres()
        response.genres.map(GenreDTO::asGenre)
    }
}