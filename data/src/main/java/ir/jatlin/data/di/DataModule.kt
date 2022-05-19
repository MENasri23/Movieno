package ir.jatlin.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.jatlin.core.data.repository.GenreRepository
import ir.jatlin.core.data.repository.MovieRepository
import ir.jatlin.data.repository.DefaultGenreRepository
import ir.jatlin.data.repository.DefaultMovieRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMovieRepository(
        movieRepository: DefaultMovieRepository
    ): MovieRepository

    @Binds
    fun bindsGenreRepository(
        genreRepository: DefaultGenreRepository
    ): GenreRepository

}