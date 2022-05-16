package ir.jatlin.webservice.api

import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface MovieApi {

    @GET(Route.DETAILS)
    suspend fun getMovieDetails(@Path("id") movieId: Long): MovieDetailsDTO

    @GET(Route.POPULAR)
    suspend fun getPopulars(@Query("page") page: Int): MoviesResponse

    @GET(Route.UPCOMING)
    suspend fun getUpcoming(@Query("page") page: Int): MoviesResponse

    @GET(Route.TOP_RATED)
    suspend fun getTopRated(@Query("page") page: Int): MoviesResponse

    @GET(Route.DISCOVER)
    suspend fun discoverMovies(
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String?,
        @QueryMap filters: Map<String, String>?
    ): MoviesResponse


    private object Route {
        const val DETAILS = "movie/{id}"
        const val POPULAR = "movie/popular"
        const val UPCOMING = "movie/upcoming"
        const val TOP_RATED = "movie/top_rated"
        const val DISCOVER = "discover/movie"
    }

}