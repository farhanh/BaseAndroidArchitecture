package com.app.cleanarchitecture.api.network

import com.app.cleanarchitecture.api.service.INoteService

/**
 * Created by Farhan on 10,March,2020
 */
interface INetworkLayer {

    fun getNoteService(): INoteService
}