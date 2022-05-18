package ir.jatlin.webservice.model.response

import com.google.gson.annotations.SerializedName
import ir.jatlin.webservice.model.movie.GenreDTO

class GenresResponse(
    @SerializedName("genres")
    val genres: List<GenreDTO>
)