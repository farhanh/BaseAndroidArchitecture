package com.sampleapp.api.utils

import com.sampleapp.common.logging.ILogger
import okhttp3.ResponseBody
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.net.ssl.SSLHandshakeException

/**
 * Class that encapsulates exceptions thrown by Retrofit
 */
class RetrofitError(rawResponse: Response<*>?, throwable: Throwable) : KoinComponent {

    companion object {
        private const val DEFAULT_STATUS_CODE = -1
        private const val TAG = "RetrofitError"
        private const val SERVER_ERROR_RANGE_START = 500
        private const val SERVER_ERROR_RANGE_END = 599
        private const val CLIENT_ERROR_RANGE_START = 400
        private const val CLIENT_ERROR_RANGE_END = 499
        private const val NOT_AUTHORIZED_ERROR = 401
        private const val FORBIDDEN_ERROR = 403
    }

    private val logger: ILogger by inject()

    private val statusCode: Int
    val errorType: ErrorType
    val errorMessage: String

    /**
     * Predefined error types.
     */
    enum class ErrorType {
        SSL_HANDSHAKE,
        TIME_OUT,
        CONNECTION,
        AUTH_FAILURE,
        CLIENT_ERROR,
        NETWORK_ERROR,
        SERVER_ERROR,
        GENERAL
    }

    init {
        statusCode = rawResponse?.code() ?: DEFAULT_STATUS_CODE
        errorType = getErrorType(throwable, statusCode)
        errorMessage = parseErrorMessage(rawResponse?.errorBody())
    }

    /**
     * Generate an error types given status code and throwable.
     */
    private fun getErrorType(throwable: Throwable, statusCode: Int): ErrorType {
        return getErrorTypeBasedOnStatusCode(statusCode)
                ?: getErrorTypeBasedOnThrowable(statusCode, throwable)
                ?: ErrorType.GENERAL
    }

    private fun getErrorTypeBasedOnStatusCode(statusCode: Int): ErrorType? {
        return when (statusCode) {
            in SERVER_ERROR_RANGE_START..SERVER_ERROR_RANGE_END -> ErrorType.SERVER_ERROR
            NOT_AUTHORIZED_ERROR, FORBIDDEN_ERROR -> ErrorType.AUTH_FAILURE
            in CLIENT_ERROR_RANGE_START..CLIENT_ERROR_RANGE_END -> ErrorType.CLIENT_ERROR
            else -> null
        }
    }

    private fun getErrorTypeBasedOnThrowable(statusCode: Int, throwable: Throwable): ErrorType? {
        return when (throwable) {
            is SSLHandshakeException -> ErrorType.SSL_HANDSHAKE
            is TimeoutException -> ErrorType.TIME_OUT
            is UnknownHostException -> ErrorType.CONNECTION
            is IOException -> if (statusCode == DEFAULT_STATUS_CODE) {
                ErrorType.CONNECTION
            } else {
                ErrorType.NETWORK_ERROR
            }
            else -> null
        }
    }

    /**
     * Parse the error message
     */
    private fun parseErrorMessage(responseBody: ResponseBody?): String {
        if (responseBody != null) {
            try {
                return responseBody.string()
            } catch (e: IOException) {
                logger.e(TAG, "Error message could not be decoded", e)
            }
        }
        return ""
    }

    fun isNetworkError(): Boolean {
        return errorType == ErrorType.NETWORK_ERROR || errorType == ErrorType.CONNECTION || errorType == ErrorType.TIME_OUT
    }
}
