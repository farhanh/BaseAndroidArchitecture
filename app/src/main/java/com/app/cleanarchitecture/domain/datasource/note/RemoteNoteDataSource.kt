package com.app.cleanarchitecture.domain.datasource.note

import com.app.cleanarchitecture.api.network.INetworkLayer
import com.app.cleanarchitecture.domain.datasource.ResultState
import com.app.cleanarchitecture.domain.model.note.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by Farhan on 11,March,2020
 */
class RemoteNoteDataSource
    @Inject constructor(private val networkService: INetworkLayer) : IRemoteNoteDataSource {

    override suspend fun getNotes(): Flow<ResultState<List<Note>>> = flow {
        emit(ResultState.Loading)
        try {
            emit(ResultState.Success(networkService.getNoteService().getNoteList().map { it.toNote() }))
        }catch (exception: Exception){
            emit(ResultState.Error(exception))
        }
    }
}