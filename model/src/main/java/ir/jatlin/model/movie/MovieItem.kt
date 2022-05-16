package ir.jatlin.model.movie

data class MovieItem(
    val id: Int,
    val isAdult: Boolean,
    val backdropPath: String,
    val genres: List<Genre>,
    val language: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val isVideo: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)