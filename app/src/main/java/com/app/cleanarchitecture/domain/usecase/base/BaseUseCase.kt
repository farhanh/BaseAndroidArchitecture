package com.app.cleanarchitecture.domain.usecase.base

import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Base class for the Use Cases that rely on a [Single] RXJava stream
 */
abstract class BaseUseCase<T, in Parameters> {

    /**
     * Builds a [Single] which will be used when the current [BaseUseCase] is executed
     */
    protected abstract suspend fun buildUseCase(params: Parameters? = null): T

    /**
     * Executes the current use case
     */

    open operator fun invoke(
        scope: CoroutineScope,
        params: Parameters? = null,
        onResult: (T) -> Unit = {}
    ) {
        scope.launch {
            withContext(Dispatchers.IO) {
                val result = buildUseCase(params)
                withContext(Dispatchers.Main) {
                    onResult(result)
                }
            }
        }
    }
}
