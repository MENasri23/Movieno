package ir.jatlin.model.movie

import ir.jatlin.model.production.Collection
import ir.jatlin.model.production.Company
import ir.jatlin.model.production.Country
import ir.jatlin.model.production.SpokenLanguage

data class MovieDetails(
    val id: Int,
    val isAdult: Boolean,
    val backdropPath: String,
    val collection: Collection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val imdbId: String,
    val originalLang: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val companies: List<Company>,
    val counties: List<Country>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLang: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val isVideo: Boolean,
    val videos: List<Video>,
    val posters: List<Poster>,
    val voteAverage: Double,
    val voteCount: Int
)