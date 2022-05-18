package ir.jatlin.data.repository.mapper.production

import ir.jatlin.model.production.SpokenLanguage
import ir.jatlin.webservice.model.production.SpokenLanguageDTO


fun SpokenLanguageDTO.asSpokenLanguage() = SpokenLanguage(
    englishName = englishName,
    isoName = iso6391,
    name = name,
)