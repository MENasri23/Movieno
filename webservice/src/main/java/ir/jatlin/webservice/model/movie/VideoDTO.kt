package ir.jatlin.webservice.model.movie

import com.google.gson.annotations.SerializedName

data class VideoDTO(
    val id: String,
    @SerializedName("iso_639_1")
    val isoLanguage: String,
    @SerializedName("iso_3166_1")
    val isoCountryName: String,
    val key: String,
    val name: String,
    val official: Boolean,
    @SerializedName("published_at")
    val publishedAt: String,
    val site: String,
    val size: Int,
    val type: String
)