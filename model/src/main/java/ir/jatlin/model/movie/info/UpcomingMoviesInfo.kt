package ir.jatlin.model.movie.info


data class UpcomingMoviesInfo(
    val start: String,
    val end: String,
    val moviesInfo: MoviesInfo
)