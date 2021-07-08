package com.app.cleanarchitecture.domain.usecase

import com.app.cleanarchitecture.domain.datasource.Result
import com.app.cleanarchitecture.domain.model.note.Note
import com.app.cleanarchitecture.domain.repository.note.INoteRepository
import com.sampleapp.domain.usecase.base.BaseUseCase

/**
 * Created by Farhan on 11,March,2020
 */
class GetNoteListUseCase(
    private val repository: INoteRepository
) : BaseUseCase<Result<List<Note>>, GetNoteListUseCase.Parameters>() {

    data class Parameters(val id: String)

    override suspend fun buildUseCase(params: Parameters?): Result<List<Note>> {
        return repository.getNoteList()
    }
}