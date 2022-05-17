package ir.jatlin.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.data.repository.DefaultMovieRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMovieRepository(
        movieRepository: DefaultMovieRepository
    ): MovieRepository

}