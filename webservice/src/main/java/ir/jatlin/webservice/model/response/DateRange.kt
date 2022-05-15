package ir.jatlin.webservice.model.response

import com.google.gson.annotations.SerializedName

data class DateRange(
    @SerializedName("maximum")
    val start: String,
    @SerializedName("minimum")
    val end: String
)