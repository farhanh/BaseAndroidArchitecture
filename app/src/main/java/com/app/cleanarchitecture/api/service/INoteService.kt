package com.app.cleanarchitecture.api.service

import com.app.cleanarchitecture.common.model.responseDTO.NoteResponseDTO
import io.reactivex.Single

/**
 * Created by Farhan on 10,March,2020
 */
interface INoteService {
    suspend fun getNoteList(): List<NoteResponseDTO>
}