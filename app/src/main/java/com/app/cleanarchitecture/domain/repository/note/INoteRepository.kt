package com.app.cleanarchitecture.domain.repository.note

import com.app.cleanarchitecture.domain.datasource.ResultState
import com.app.cleanarchitecture.domain.model.note.Note
import kotlinx.coroutines.flow.Flow

/**
 * Created by Farhan on 26,February,2020
 */
interface INoteRepository {
    suspend fun getNoteList(): Flow<ResultState<List<Note>>>
}