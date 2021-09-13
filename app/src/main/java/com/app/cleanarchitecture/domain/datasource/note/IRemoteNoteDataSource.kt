package com.app.cleanarchitecture.domain.datasource.note

import com.app.cleanarchitecture.domain.datasource.ResultState
import com.app.cleanarchitecture.domain.model.note.Note
import kotlinx.coroutines.flow.Flow

/**
 * Created by Farhan on 11,March,2020
 */
interface IRemoteNoteDataSource {

    suspend fun getNotes(): Flow<ResultState<List<Note>>>
}