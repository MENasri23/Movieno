package ir.jatlin.domain.movie.genre

import ir.jatlin.core.data.repository.GenreRepository
import ir.jatlin.core.shared.result.fail.ErrorHandler
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.domain.CoroutineUseCase
import ir.jatlin.model.movie.Genre
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


class GetAllGenresUseCase @Inject constructor(
    private val genreRepository: GenreRepository,
    errorHandler: ErrorHandler,
    @IODispatcher dispatcher: CoroutineDispatcher
) : CoroutineUseCase<Unit, List<Genre>>(errorHandler, dispatcher) {

    override suspend fun execute(params: Unit): List<Genre> {
        return genreRepository.getAllGenres()
    }
}