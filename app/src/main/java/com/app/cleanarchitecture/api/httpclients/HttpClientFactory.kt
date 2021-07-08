package com.app.cleanarchitecture.api.httpclients

import com.app.cleanarchitecture.api.endpoints.IServiceDefinition
import com.sampleapp.common.logging.ILogger
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Farhan on 10,March,2020
 */
class HttpClientFactory (private val baseUrl: String): IHttpFactory<IServiceDefinition>, KoinComponent {

    companion object {
        private const val TAG = "NoteHttpClientFactory"
        private const val OK_HTTP_LOG_TAG = "OkHttp"
        private const val OK_HTTP_CONTENT_TYPE_KEY = "Content-Type"
        private const val OK_HTTP_CONTENT_TYPE = "application/json"
    }

    private val logger: ILogger by inject()

    override fun create(): IServiceDefinition {

        val httpClient = OkHttpClient.Builder()

        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                // log through our own Logger
                logger.d(OK_HTTP_LOG_TAG, message)
            }
        }).apply {
            this.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(this)
        }

        httpClient.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.header(OK_HTTP_CONTENT_TYPE_KEY, OK_HTTP_CONTENT_TYPE)
                return chain.proceed(requestBuilder.build())
            }
        })

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .client(httpClient.build()).build()

        return retrofit.create(IServiceDefinition::class.java)
    }
}