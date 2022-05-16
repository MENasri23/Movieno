package ir.jatlin.webservice.api

import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface MovieApi {

    @GET(Route.DETAILS)
    suspend fun getMovieDetails(
        @Path(PARAMS.MOVIE_ID) movieId: Long
    ): MovieDetailsDTO

    @GET(Route.POPULAR)
    suspend fun getPopulars(@Query(PARAMS.PAGE) page: Int): MoviesResponse

    @GET(Route.UPCOMING)
    suspend fun getUpcoming(@Query(PARAMS.PAGE) page: Int): MoviesResponse

    @GET(Route.TOP_RATED)
    suspend fun getTopRated(@Query(PARAMS.PAGE) page: Int): MoviesResponse

    @GET(Route.DISCOVER)
    suspend fun discoverMovies(
        @Query(PARAMS.PAGE) page: Int,
        @Query(PARAMS.SORT_BY) sortBy: String?,
        @QueryMap filters: Map<String, String>?
    ): MoviesResponse


    private object Route {
        const val DETAILS = "movie/{id}"
        const val POPULAR = "movie/popular"
        const val UPCOMING = "movie/upcoming"
        const val TOP_RATED = "movie/top_rated"
        const val DISCOVER = "discover/movie"
    }

    private object PARAMS {
        const val MOVIE_ID = "id"
        const val PAGE = "page"
        const val SORT_BY = "sort_by"
    }

}