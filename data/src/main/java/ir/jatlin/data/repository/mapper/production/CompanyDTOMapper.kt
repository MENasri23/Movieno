package ir.jatlin.data.repository.mapper.production

import ir.jatlin.model.production.Company
import ir.jatlin.webservice.model.production.CompanyDTO


fun CompanyDTO.asCompany() = Company(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry,
)