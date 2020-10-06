package pl.kaszmir.templatemvvm.core.base

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> {

    abstract suspend fun action(params: Params): Type

    operator fun invoke(
        params: Params,
        scope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO, // default value Dispatchers.IO
        onResult: (Result<Type>) -> Unit = {} // default value empty lambda
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
                runCatching { action(params) }
            }
            onResult(result)
        }
    }
}