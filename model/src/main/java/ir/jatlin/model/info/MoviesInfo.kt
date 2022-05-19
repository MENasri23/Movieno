package ir.jatlin.model.info

import ir.jatlin.model.movie.MovieItem

data class MoviesInfo(
    val currentPage: Int,
    val movieItems: List<MovieItem>,
    val totalPages: Int,
    val totalResults: Int
)