package ir.jatlin.data.repository.mapper.movie

import ir.jatlin.data.repository.mapper.production.asCollection
import ir.jatlin.data.repository.mapper.production.asCompany
import ir.jatlin.data.repository.mapper.production.asCountry
import ir.jatlin.data.repository.mapper.production.asSpokenLanguage
import ir.jatlin.model.movie.MovieDetails
import ir.jatlin.webservice.model.movie.GenreDTO
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.movie.PosterDTO
import ir.jatlin.webservice.model.movie.VideoDTO
import ir.jatlin.webservice.model.production.CompanyDTO
import ir.jatlin.webservice.model.production.CountryDTO
import ir.jatlin.webservice.model.production.SpokenLanguageDTO


fun MovieDetailsDTO.asMovieDetails(

    ) = MovieDetails(
    id = id,
    isAdult = isAdult,
    backdropPath = backdropPath,
    collection = collection.asCollection(),
    budget = budget,
    genres = genres.map(GenreDTO::asGenre),
    homepage = homepage,
    imdbId = imdbId,
    originalLang = originalLang,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    companies = companies.map(CompanyDTO::asCompany),
    counties = counties.map(CountryDTO::asCountry),
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLang = spokenLang.map(SpokenLanguageDTO::asSpokenLanguage),
    status = status,
    tagline = tagline,
    title = title,
    isVideo = isVideo,
    videos = videos.map(VideoDTO::asVideo),
    posters = posters.map(PosterDTO::asPoster),
    voteAverage = voteAverage,
    voteCount = voteCount,
)