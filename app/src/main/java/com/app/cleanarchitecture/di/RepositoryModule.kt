package com.app.cleanarchitecture.di

import com.app.cleanarchitecture.api.network.INetworkLayer
import com.app.cleanarchitecture.api.network.NetworkLayer
import com.app.cleanarchitecture.domain.datasource.note.IRemoteNoteDataSource
import com.app.cleanarchitecture.domain.datasource.note.RemoteNoteDataSource
import com.app.cleanarchitecture.domain.repository.note.INoteRepository
import com.app.cleanarchitecture.domain.repository.note.NoteRepository
import com.sampleapp.common.logging.ILogger
import com.sampleapp.common.logging.Logger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(noteRepositoryImpl: NoteRepository): INoteRepository

    @Binds
    abstract fun bindRemoteNoteDataSource(remoteNoteDataSourceImpl: RemoteNoteDataSource): IRemoteNoteDataSource

    @Binds
    abstract fun bindNetworkLayer(networkLayerImpl: NetworkLayer): INetworkLayer
}




















