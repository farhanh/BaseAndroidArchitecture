package com.app.cleanarchitecture.domain.repository.note

import com.app.cleanarchitecture.domain.datasource.Result
import com.app.cleanarchitecture.domain.model.note.Note
import io.reactivex.Single

/**
 * Created by Farhan on 26,February,2020
 */
interface INoteRepository {
    suspend fun getNoteList(): Result<List<Note>>
}