package com.sampleapp.domain.usecase.base

import com.app.cleanarchitecture.domain.datasource.Result
import com.app.cleanarchitecture.domain.model.note.Note
import io.reactivex.Single
import kotlinx.coroutines.*

/**
 * Base class for the Use Cases that rely on a [Single] RXJava stream
 */
abstract class BaseUseCase<T, in Parameters>{

    /**
     * Builds a [Single] which will be used when the current [BaseUseCase] is executed
     */
    protected abstract suspend fun buildUseCase(params: Parameters? = null): Result<List<Note>>

    /**
     * Executes the current use case
     */

    open operator fun invoke(
        scope: CoroutineScope,
        params: Parameters? = null,
        onResult: (Result<List<Note>>) -> Unit = {}
    ) {
        scope.launch {
            val result = buildUseCase(params)
            withContext(Dispatchers.Main){
                onResult(result)
            }
        }
    }
}
