package com.app.cleanarchitecture.domain.repository.note

import com.app.cleanarchitecture.domain.datasource.Result
import com.app.cleanarchitecture.domain.datasource.note.IRemoteNoteDataSource
import com.app.cleanarchitecture.domain.model.note.Note
import com.sampleapp.common.logging.ILogger
import javax.inject.Inject

/**
 * Created by Farhan on 11,March,2020
 */
class NoteRepository
    @Inject constructor(private val remoteNoteSource:IRemoteNoteDataSource): INoteRepository {

    @Inject
    lateinit var logger: ILogger

    companion object {
        private val TAG = NoteRepository.javaClass.name
    }

    override suspend fun getNoteList(): Result<List<Note>> {
        logger.i(TAG, "getNoteList")
        return remoteNoteSource.getNotes()
    }
}