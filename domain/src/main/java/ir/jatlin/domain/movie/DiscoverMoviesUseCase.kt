package ir.jatlin.domain.movie

import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.domain.FlowUseCase
import ir.jatlin.model.movie.info.MoviesInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DiscoverMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : FlowUseCase<DiscoverMoviesUseCase.Prams, MoviesInfo>() {

    override fun execute(params: Prams): Flow<MoviesInfo> {
        return movieRepository.discoverMovies(
            page = params.page,
            sortBy = params.sortBy,
            filters = params.filters
        )
    }

    data class Prams(
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