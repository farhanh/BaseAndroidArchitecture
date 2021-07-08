package com.app.cleanarchitecture.domain.datasource.note

import com.app.cleanarchitecture.api.network.INetworkLayer
import com.app.cleanarchitecture.domain.datasource.Result
import com.app.cleanarchitecture.domain.model.note.Note
import io.reactivex.Single

/**
 * Created by Farhan on 11,March,2020
 */
class RemoteNoteDataSource(private val networkService: INetworkLayer) : IRemoteNoteDataSource {

    override suspend fun getNotes(): Result<List<Note>> {
        return Result.Success(networkService.getNoteService().getNoteList().map { it.toNote() })
    }
}