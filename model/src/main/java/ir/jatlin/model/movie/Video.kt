package ir.jatlin.model.movie

data class Video(
    val id: String,
    val isoLanguage: String,
    val isoCountryName: String,
    val key: String,
    val name: String,
    val official: Boolean,
    val publishedAt: String,
    val site: String,
    val size: Int,
    val type: String
)