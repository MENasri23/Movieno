package ir.jatlin.core.data.repository

import ir.jatlin.model.movie.Genre

interface GenreRepository {

    suspend fun getAllGenres(): List<Genre>

    suspend fun getGenreById(id: Int): Genre?
}