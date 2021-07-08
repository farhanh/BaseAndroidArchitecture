package com.app.cleanarchitecture.api.endpoints

import com.app.cleanarchitecture.common.model.responseDTO.NoteResponseDTO
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Farhan on 10,March,2020
 */
interface IServiceDefinition {

    companion object{
        private const val ENDPOINT_NOTE_LIST = "/notes"
    }

    @GET(ENDPOINT_NOTE_LIST)
    suspend fun getNoteList(): List<NoteResponseDTO>


}