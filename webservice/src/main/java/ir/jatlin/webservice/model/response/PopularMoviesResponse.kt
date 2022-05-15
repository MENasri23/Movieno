package ir.jatlin.webservice.model.response

data class PopularMoviesResponse(
    val dates: DateRange,
    val moviesResponse: MoviesResponse
)