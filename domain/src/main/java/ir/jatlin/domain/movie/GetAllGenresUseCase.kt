package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.GenreRepository
import ir.jatlin.model.movie.Genre
import javax.inject.Inject

class GetAllGenresUseCase @Inject constructor(
    private val genreRepository: GenreRepository
) {

    suspend operator fun invoke(): List<Genre> =
        genreRepository.getAllGenres()
}