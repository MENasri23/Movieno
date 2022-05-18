package ir.jatlin.data.repository.mapper.production

import ir.jatlin.model.production.Country
import ir.jatlin.webservice.model.production.CountryDTO


fun CountryDTO.asCountry() = Country(
isoName = isoName,
name = name,
)