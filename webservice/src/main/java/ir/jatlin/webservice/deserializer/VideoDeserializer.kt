package ir.jatlin.webservice.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import ir.jatlin.webservice.model.movie.VideoDTO
import java.lang.reflect.Type

class VideoDTODeserializer : JsonDeserializer<List<VideoDTO>?> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<VideoDTO>? {
        val jsonObject = json?.asJsonObject ?: return null
        return mapToVideoList(jsonObject)
    }

    private fun mapToVideoList(json: JsonObject): List<VideoDTO> =
        json["results"].asJsonArray.map(::toVideoDTO)

    private fun toVideoDTO(element: JsonElement) = element.asJsonObject.run {
        VideoDTO(
            id = this["id"].asString,
            isoLanguage = this["iso_639_1"].asString,
            isoCountryName = this["iso_3166_1"].asString,
            name = this["name"].asString,
            key = this["key"].asString,
            site = this["site"].asString,
            size = this["size"].asInt,
            type = this["type"].asString,
            official = this["official"].asBoolean,
            publishedAt = this["published_at"].asString
        )
    }
}