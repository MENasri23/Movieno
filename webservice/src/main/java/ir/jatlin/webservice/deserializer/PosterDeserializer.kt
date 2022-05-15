package ir.jatlin.webservice.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import ir.jatlin.webservice.model.movie.PosterDTO
import java.lang.reflect.Type

class PosterDeserializer : JsonDeserializer<List<PosterDTO>?> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<PosterDTO>? {
        val jsonObject = json?.asJsonObject ?: return null
        return mapToPosterList(jsonObject)
    }

    private fun mapToPosterList(json: JsonObject): List<PosterDTO> =
        json["posters"].asJsonArray.map(::toPosterDTO)

    private fun toPosterDTO(element: JsonElement) = element.asJsonObject.run {
        PosterDTO(
            aspectRatio = this["aspect_ratio"].asDouble,
            filePath = this["file_path"].asString,
            height = this["height"].asInt,
            width = this["width"].asInt,
        )
    }
}