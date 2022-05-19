package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.core.shared.result.fail.ErrorHandler
import ir.jatlin.data.di.IODispatcher
import ir.jatlin.domain.CoroutineUseCase
import ir.jatlin.model.movie.info.MoviesInfo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DiscoverMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    errorHandler: ErrorHandler,
    @IODispatcher dispatcher: CoroutineDispatcher
) : CoroutineUseCase<DiscoverMoviesUseCase.Params, MoviesInfo>(errorHandler, dispatcher) {

    override suspend fun execute(params: Params): MoviesInfo {
        return movieRepository.discoverMovies(
            page = params.page,
            sortBy = params.sortBy,
            filters = params.filters
        )
    }

    data class Params(
        val page: Int,
        val sortBy: String? = null,
    ) {
        var filters: MutableMap<String, String>? = null
            private set

        fun put(key: String, value: String) {
            val map = filters ?: createFilters()
            map[key] = value
        }

        fun putAll(queryFilters: Iterable<Pair<String, String>>) {
            val map = filters ?: createFilters()
            map.putAll(queryFilters)
        }

        fun remove(key: String) = filters?.remove(key)

        private fun createFilters() =
            mutableMapOf<String, String>().also {
                filters = it
            }

    }
}