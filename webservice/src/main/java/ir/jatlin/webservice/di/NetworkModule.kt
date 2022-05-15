package ir.jatlin.webservice.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.jatlin.webservice.api.MovieApi
import ir.jatlin.webservice.deserializer.PosterDeserializer
import ir.jatlin.webservice.deserializer.VideoDTODeserializer
import ir.jatlin.webservice.model.movie.PosterDTO
import ir.jatlin.webservice.model.movie.VideoDTO
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun providesRetroFit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()


    @Singleton
    @Provides
    fun jsonConvertorFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)


    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .registerTypeAdapter(
            object : TypeToken<ArrayList<VideoDTO>>() {}.type,
            VideoDTODeserializer()
        )
        .registerTypeAdapter(
            object : TypeToken<ArrayList<PosterDTO>>() {}.type,
            PosterDeserializer()
        )
        .create()


    @Singleton
    @Provides
    fun providesService(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)

}