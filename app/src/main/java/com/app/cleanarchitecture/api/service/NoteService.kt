package com.app.cleanarchitecture.api.service

import com.app.cleanarchitecture.api.endpoints.IServiceDefinition
import com.app.cleanarchitecture.api.httpclients.IHttpFactory
import com.app.cleanarchitecture.common.model.responseDTO.NoteResponseDTO
import io.reactivex.Single

/**
 * Created by Farhan on 10,March,2020
 */
class NoteService(httpClientFactory: IHttpFactory<IServiceDefinition>) : INoteService {

    val api: IServiceDefinition by lazy { httpClientFactory.create() }

    override suspend fun getNoteList(): List<NoteResponseDTO> {
        return api.getNoteList()
    }
}