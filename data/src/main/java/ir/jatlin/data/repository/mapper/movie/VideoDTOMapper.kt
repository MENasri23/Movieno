package ir.jatlin.data.repository.mapper.movie

import ir.jatlin.model.movie.Video
import ir.jatlin.webservice.model.movie.VideoDTO


fun VideoDTO.asVideo() = Video(
id = id,
isoLanguage = isoLanguage,
isoCountryName = isoCountryName,
key = key,
name = name,
official = official,
publishedAt = publishedAt,
site = site,
size = size,
type = type,
)