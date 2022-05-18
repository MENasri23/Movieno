package ir.jatlin.data.repository.mapper.production

import ir.jatlin.model.production.Collection
import ir.jatlin.webservice.model.production.CollectionDTO


fun CollectionDTO.asCollection() = Collection(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath,
)