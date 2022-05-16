package ir.jatlin.webservice.model.response

data class UpcomingMoviesResponse(
    val dates: DateRange,
    val moviesResponse: MoviesResponse
)