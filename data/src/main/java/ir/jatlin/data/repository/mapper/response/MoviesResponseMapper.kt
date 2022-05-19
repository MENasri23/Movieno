package ir.jatlin.data.repository.mapper.response

import ir.jatlin.model.movie.MovieItem
import ir.jatlin.model.info.MoviesInfo
import ir.jatlin.webservice.model.response.MoviesResponse


fun MoviesResponse.asExternalModel(
    movieItems: List<MovieItem>
) = MoviesInfo(
    currentPage = currentPage,
    movieItems = movieItems,
    totalPages = totalPages,
    totalResults = totalResults,
)