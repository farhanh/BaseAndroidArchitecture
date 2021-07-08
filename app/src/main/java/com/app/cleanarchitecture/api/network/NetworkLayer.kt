package com.app.cleanarchitecture.api.network

import com.app.cleanarchitecture.api.httpclients.HttpClientFactory
import com.app.cleanarchitecture.api.service.INoteService
import com.app.cleanarchitecture.api.service.NoteService

/**
 * Created by Farhan on 10,March,2020
 */
class NetworkLayer(val baseUrl: String) : INetworkLayer {

    val noteServiceInstance: INoteService by lazy {
        NoteService(HttpClientFactory(baseUrl))
    }

    override fun getNoteService(): INoteService {
        return noteServiceInstance
    }
}