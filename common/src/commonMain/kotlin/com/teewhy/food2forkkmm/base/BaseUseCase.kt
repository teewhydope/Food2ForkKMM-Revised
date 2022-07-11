package com.teewhy.food2forkkmm.base

import cc.popkorn.annotations.Exclude
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Exclude
abstract class BaseUseCase<I, O> : UseCase<I, O> {
    final override suspend fun execute(input: I, callback: (O) -> Unit) {
        val result = withContext(Dispatchers.Default) {
            execute(input, this)
        }
        callback(result)
    }

    abstract suspend fun execute(
        request: I,
        coroutineScope: CoroutineScope
    ): O
}
