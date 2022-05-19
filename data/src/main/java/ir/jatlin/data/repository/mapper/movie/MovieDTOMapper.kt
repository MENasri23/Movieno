package ir.jatlin.data.repository.mapper.movie

import ir.jatlin.model.movie.Genre
import ir.jatlin.model.movie.MovieItem
import ir.jatlin.webservice.model.movie.MovieDTO


fun MovieDTO.asMovieItem(
    genres: List<Genre>,
) = MovieItem(
    id = id,
    isAdult = isAdult,
    backdropPath = backdropPath,
    genres = genres,
    language = originalLang,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    isVideo = isVideo,
    voteAverage = voteAverage,
    voteCount = voteCount,
)