package com.teewhy.food2forkkmm.base

import kotlinx.coroutines.CoroutineScope

interface BaseUseCase<R, O> {
    suspend fun execute(
        request: R,
        coroutineScope: CoroutineScope
    ): O
}
