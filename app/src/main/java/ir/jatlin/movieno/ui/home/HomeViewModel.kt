package ir.jatlin.movieno.ui.home

import dagger.hilt.android.lifecycle.HiltViewModel
import ir.jatlin.core.shared.result.Resource
import ir.jatlin.core.shared.result.Resource.*
import ir.jatlin.core.shared.result.Resource.Companion.success
import ir.jatlin.domain.movie.GetPopularMoviesUesCase
import ir.jatlin.domain.movie.genre.GetAllGenresUseCase
import ir.jatlin.model.movie.Genre
import ir.jatlin.model.movie.info.MoviesInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllGenres: GetAllGenresUseCase,
    private val getPopularMovies: GetPopularMoviesUesCase
) {

    private val _populars = MutableStateFlow<Resource<List<MoviesInfo>>>(success(emptyList()))
    val populars = _populars.asStateFlow()

    private val _genres = MutableStateFlow<Resource<List<Genre>>>(success(emptyList()))
    val genres = _genres.asStateFlow()


}