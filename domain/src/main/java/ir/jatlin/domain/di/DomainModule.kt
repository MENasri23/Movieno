package ir.jatlin.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.jatlin.core.shared.result.fail.ErrorHandler
import ir.jatlin.domain.util.DefaultErrorHandler

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    fun bindsErrorHandler(
        handler: DefaultErrorHandler
    ): ErrorHandler
}