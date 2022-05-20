package ir.jatlin.domain.movie.filter

data class MovieParameters(
    val page: Int,
    val sortBy: String? = null,
    val filters: Map<String, String>? = null
)

