package com.app.cleanarchitecture.api.httpclients

/**
 * Created by Farhan on 10,March,2020
 */
interface IHttpFactory<T> {
    fun create(): T
}