package com.app.cleanarchitecture.app.ui.note

import com.app.cleanarchitecture.domain.model.note.Note

/**
 * Created by Farhan on 10,March,2020
 */
sealed class NoteListResult {
    data class Success(val noteList: List<Note>) : NoteListResult()
    data class Error(val error: String?) : NoteListResult()
}