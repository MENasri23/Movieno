package ir.jatlin.webservice.model.production

import com.google.gson.annotations.SerializedName

data class CompanyDTO(
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)