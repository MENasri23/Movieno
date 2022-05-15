package ir.jatlin.webservice.model.movie

import com.google.gson.annotations.SerializedName
import ir.jatlin.webservice.model.production.CollectionDTO
import ir.jatlin.webservice.model.production.CompanyDTO
import ir.jatlin.webservice.model.production.CountryDTO
import ir.jatlin.webservice.model.production.SpokenLanguageDTO

data class MovieDetailsDTO(
    val id: Int,
    @SerializedName("adult")
    val isAdult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val collection: CollectionDTO,
    val budget: Int,
    val genres: List<GenreDTO>,
    val homepage: String,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLang: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("production_companies")
    val companies: List<CompanyDTO>,
    @SerializedName("production_countries")
    val counties: List<CountryDTO>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spokenLang: List<SpokenLanguageDTO>,
    val status: String,
    val tagline: String,
    val title: String,
    @SerializedName("video")
    val isVideo: Boolean,
    val videos: List<VideoDTO>,
    @SerializedName("images")
    val posters: List<PosterDTO>,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)