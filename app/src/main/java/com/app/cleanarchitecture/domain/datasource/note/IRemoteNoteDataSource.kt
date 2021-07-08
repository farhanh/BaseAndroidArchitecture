package com.app.cleanarchitecture.domain.datasource.note

import com.app.cleanarchitecture.domain.model.note.Note
import com.app.cleanarchitecture.domain.datasource.Result
import io.reactivex.Single

/**
 * Created by Farhan on 11,March,2020
 */
interface IRemoteNoteDataSource {

    suspend fun getNotes(): Result<List<Note>>
}