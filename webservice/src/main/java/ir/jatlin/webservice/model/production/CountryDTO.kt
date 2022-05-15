package ir.jatlin.webservice.model.production

import com.google.gson.annotations.SerializedName

data class CountryDTO(
    @SerializedName("iso_3166_1")
    val isoName: String,
    val name: String
)