package ir.jatlin.movieno.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.jatlin.core.shared.result.Resource
import ir.jatlin.core.shared.result.fail.ErrorCause
import ir.jatlin.core.shared.result.isSuccess
import ir.jatlin.domain.movie.DiscoverMoviesUseCase
import ir.jatlin.domain.movie.GetPopularMoviesUesCase
import ir.jatlin.domain.movie.filter.movieFilterParams
import ir.jatlin.domain.movie.genre.GetAllGenresUseCase
import ir.jatlin.model.movie.Genre
import ir.jatlin.model.movie.MovieItem
import ir.jatlin.model.movie.info.MoviesInfo
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllGenres: GetAllGenresUseCase,
    private val discoverMovies: DiscoverMoviesUseCase,
    private val getPopularMovies: GetPopularMoviesUesCase
) : ViewModel() {

    private val _movieCategories = MutableStateFlow<Resource<List<MoviesUiState>>>(
        Resource.success(emptyList())
    )
    val movieCategories = _movieCategories.asStateFlow()

    private val _errorCause = MutableStateFlow<ErrorCause?>(null)
    val errorCause = _errorCause.asStateFlow()

    init {
        fetchAllGenres()
    }

    val popularMovies: StateFlow<Resource<MoviesInfo>> = getPopularMovies(1)
        .stateIn(
            initialValue = Resource.loading(),
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L)
        )


    private fun fetchAllGenres() = viewModelScope.launch {
        getAllGenres(Unit).let { genresResult ->
            when (genresResult) {
                is Resource.Error -> handleError(genresResult.cause)
                is Resource.Loading -> {}
                is Resource.Success -> {
                    val genres = genresResult.data
                    fetchMovieCategories(genres)
                }
            }
        }
    }

    private suspend fun fetchMovieCategories(genres: List<Genre>?) {
        genres ?: return

        val deferredMovies = genres.map { sGenre ->
            viewModelScope.async {
                val resource = discoverMovies(
                    params = movieFilterParams { genre = sGenre.name }
                )
                if (resource.isSuccess) {
                    resource.data!!
                } else {
                    when (resource) {
                        is Resource.Error -> _errorCause.emit(resource.cause)
                        else -> _errorCause.emit(ErrorCause.Unknown())
                    }
                    throw CancellationException()
                }
            }

        }

        try {
            val moviesCategories = deferredMovies.awaitAll().map { MoviesUiState(it.movieItems) }
            _movieCategories.emit(Resource.success(moviesCategories))
        } catch (t: Throwable) {
            Timber.d(t.cause)
//            _movieCategories.emit(Resource.error())
        }


    }

    private fun handleError(cause: ErrorCause?) {
        // Handle error
    }


}

data class HomeUiState(
    val popularMovies: MoviesInfo,
    val movieCategories: MoviesUiState
)

data class MoviesUiState(
    val movies: List<MovieItem>,
)