package com.app.cleanarchitecture.domain.datasource.note

import com.app.cleanarchitecture.common.model.responseDTO.NoteResponseDTO
import com.app.cleanarchitecture.domain.model.note.Note


/**
 * Created by Farhan on 26,February,2020
 */
fun NoteResponseDTO.toNote(): Note {
    return Note(id, name, "$starttime $endtime")
}