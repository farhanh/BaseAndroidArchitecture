package com.app.cleanarchitecture.domain.usecase

import com.app.cleanarchitecture.domain.datasource.ResultState
import com.app.cleanarchitecture.domain.model.note.Note
import com.app.cleanarchitecture.domain.repository.note.INoteRepository
import com.app.cleanarchitecture.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.flow.Flow

/**
 * Created by Farhan on 11,March,2020
 */
class GetNoteListUseCase(
    private val repository: INoteRepository
) : BaseUseCase<Flow<ResultState<List<Note>>>, GetNoteListUseCase.Parameters>() {

    data class Parameters(val id: String)

    override suspend fun buildUseCase(params: Parameters?): Flow<ResultState<List<Note>>> {
        return repository.getNoteList()
    }

}