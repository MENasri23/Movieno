package ir.jatlin.webservice.api

import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface MovieApi {

    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") movieId: Long): MovieDetailsDTO

    @GET("movie/popular")
    suspend fun getPopulars(@Query("page") page: Int): MoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpcoming(@Query("page") page: Int): MoviesResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(@Query("page") page: Int): MoviesResponse

    @GET("discover/movie")
    suspend fun discoverMovies(
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String?,
        @QueryMap filters: Map<String, String>?
    ): MoviesResponse

}