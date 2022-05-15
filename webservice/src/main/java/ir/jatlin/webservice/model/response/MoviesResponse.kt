package ir.jatlin.webservice.model.response

import com.google.gson.annotations.SerializedName
import ir.jatlin.webservice.model.movie.MovieDTO


data class MoviesResponse(
    @SerializedName("page")
    val currentPage: Int,
    @SerializedName("results")
    val movieList: List<MovieDTO>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)