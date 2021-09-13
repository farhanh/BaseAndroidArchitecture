package com.app.cleanarchitecture.app.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.cleanarchitecture.app.ui.BaseViewModel
import com.app.cleanarchitecture.domain.datasource.ResultState
import com.app.cleanarchitecture.domain.model.note.Note
import com.app.cleanarchitecture.domain.repository.note.INoteRepository
import com.app.cleanarchitecture.domain.usecase.GetNoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Farhan on 11,March,2020
 */
@HiltViewModel
class NoteListViewModel @Inject constructor(noteRepository: INoteRepository) : BaseViewModel() {

    private val _noteListLiveData: MutableLiveData<ResultState<List<Note>>> = MutableLiveData()
    val noteListLiveData: LiveData<ResultState<List<Note>>>
        get() = _noteListLiveData


    private val getNoteListUseCase = GetNoteListUseCase(
        noteRepository
    )

    protected fun getNoteList() {
        val params = GetNoteListUseCase.Parameters("1234")
        getNoteListUseCase.invoke(viewModelScope, params) {
            it.onEach { state ->
                _noteListLiveData.value = state
            }
        }
    }

    fun onStartEvent(event: NoteEvents) {
        when (event) {
            is NoteEvents.GetNoteList -> {
                getNoteList()
            }
        }
    }
}

sealed class NoteEvents {
    object GetNoteList : NoteEvents()
}