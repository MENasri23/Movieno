package ir.jatlin.webservice.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import ir.jatlin.webservice.model.response.DateRange
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import java.lang.reflect.Type

class UpcomingMovieDeserializer : JsonDeserializer<UpcomingMoviesResponse?> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): UpcomingMoviesResponse? {
        return json?.asJsonObject?.let { jsonObject ->
            context ?: return@let null

            UpcomingMoviesResponse(
                dates = context.deserialize(jsonObject["dates"], DateRange::class.java),
                moviesResponse = context.deserialize(jsonObject, MoviesResponse::class.java)
            )
        }
    }
}