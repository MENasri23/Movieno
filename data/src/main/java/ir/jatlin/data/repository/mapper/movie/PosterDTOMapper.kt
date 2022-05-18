package ir.jatlin.data.repository.mapper.movie

import ir.jatlin.model.movie.Poster
import ir.jatlin.webservice.model.movie.PosterDTO


fun PosterDTO.asPoster() = Poster(
aspectRatio = aspectRatio,
filePath = filePath,
height = height,
width = width,
)