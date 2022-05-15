package ir.jatlin.webservice.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoggingInterceptor


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HeaderInterceptor