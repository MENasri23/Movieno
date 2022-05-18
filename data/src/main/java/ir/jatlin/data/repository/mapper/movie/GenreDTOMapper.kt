package ir.jatlin.data.repository.mapper.movie

import ir.jatlin.model.movie.Genre
import ir.jatlin.webservice.model.movie.GenreDTO

fun GenreDTO.asGenre() = Genre(
id = id,
name = name,
)