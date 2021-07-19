package com.app.cleanarchitecture.app.ui.note

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.cleanarchitecture.app.ui.BaseViewModel
import com.app.cleanarchitecture.domain.datasource.Result
import com.app.cleanarchitecture.domain.repository.note.INoteRepository
import com.app.cleanarchitecture.domain.usecase.GetNoteListUseCase
import com.sampleapp.common.logging.ILogger
import com.sampleapp.common.logging.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Farhan on 11,March,2020
 */
@HiltViewModel
class NoteListViewModel
@Inject constructor(
    noteRepository: INoteRepository,
) : BaseViewModel() {

    private val getNoteListUseCase = GetNoteListUseCase(
        noteRepository
    )


    val noteList by lazy {
        val liveData = MutableLiveData<NoteListResult>()
        val params = GetNoteListUseCase.Parameters("1234")

        getNoteListUseCase.invoke(viewModelScope, params) {
            when (it) {
                is Result.Success -> liveData.value = NoteListResult.Success((it).data)
                is Result.Error -> liveData.value = NoteListResult.Error((it).toString())
            }
        }

        return@lazy liveData
    }
}