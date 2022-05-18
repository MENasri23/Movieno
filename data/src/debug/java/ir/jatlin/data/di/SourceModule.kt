package ir.jatlin.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.jatlin.core.data.source.MovieRemoteDataSource
import ir.jatlin.data.source.remote.FakeMovieRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
interface SourceModule {

    @Binds
    fun bindsMovieRemoteDataSource(
        remote: FakeMovieRemoteDataSource
    ): MovieRemoteDataSource
}