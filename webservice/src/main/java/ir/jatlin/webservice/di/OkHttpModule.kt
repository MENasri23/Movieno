package ir.jatlin.webservice.di

import dagger.Provides
import ir.jatlin.webservice.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

object OkHttpModule {
    private const val API_KEY = BuildConfig.API_KEY


    @Singleton
    @Provides
    fun provideOkHttpClient(
        @HeaderInterceptor header: Interceptor,
        @LoggingInterceptor logging: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(header)
        .addInterceptor(logging)
        .build()


    @Provides
    @HeaderInterceptor
    fun provideHeaderInterceptor() = Interceptor { chain ->
        val request = chain.request()
        val newRequest = request.newBuilder().apply {
            url(
                request.url.newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()
            )
        }.build()

        chain.proceed(newRequest)
    }


    @Provides
    @LoggingInterceptor
    fun provideHttpLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

}