package com.app.cleanarchitecture.di

import com.app.cleanarchitecture.common.logging.ILogger
import com.sampleapp.common.logging.Logger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsModule {

    @Binds
    abstract fun bindLogger(loggerImpl: Logger): ILogger

}




















