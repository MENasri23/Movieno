package ir.jatlin.domain.movie.filter

class MovieFilterParameters {

    // which page to discover
    var page: Int = 1

    var genre: String = ""

    // filter with genre's name
    var genres: Array<String>? = null

    // provide result this sort strategy
    var sortBy: String = ""

    // weather or not child can see the movie
    var forAdult: Boolean = false

    // determine weather the movie videos be fetched or not
    var includeVideo: Boolean = false

}


fun movieFilterParams(
    build: MovieFilterParameters.() -> Unit
): MovieParameters {
    return MovieFilterParameters().apply(build).run {
        val paramsMaker = DefaultParameterMaker<String, String>().apply {
            putAll(
                "genre" to (genres?.joinToString() ?: genre),
                "sort_by" to sortBy,
                "include_adult" to forAdult.toString(),
                "include_video" to includeVideo.toString()
            )
        }
        MovieParameters(
            page = page,
            sortBy = sortBy,
            filters = paramsMaker.params
        )
    }
}