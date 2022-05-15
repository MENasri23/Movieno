package ir.jatlin.webservice.model.movie

import com.google.gson.annotations.SerializedName

data class PosterDTO(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double,
    @SerializedName("file_path")
    val filePath: String,
    val height: Int,
    val width: Int,
)