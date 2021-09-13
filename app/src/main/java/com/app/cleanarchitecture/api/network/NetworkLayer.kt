package com.app.cleanarchitecture.api.network

import com.app.cleanarchitecture.BuildConfig
import com.app.cleanarchitecture.api.httpclients.HttpClientFactory
import com.app.cleanarchitecture.api.service.INoteService
import com.app.cleanarchitecture.api.service.NoteService
import javax.inject.Inject

/**
 * Created by Farhan on 10,March,2020
 */
class NetworkLayer
@Inject constructor() : INetworkLayer {

    val noteServiceInstance: INoteService by lazy {
        NoteService(HttpClientFactory(BuildConfig.BASE_URL))
    }

    override fun getNoteService(): INoteService {
        return noteServiceInstance
    }
}