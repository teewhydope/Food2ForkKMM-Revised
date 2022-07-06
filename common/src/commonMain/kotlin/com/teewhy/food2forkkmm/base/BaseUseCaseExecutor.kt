package com.teewhy.food2forkkmm.base

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseUseCaseExecutor(
    var coroutineScope: CoroutineScope
) {
    private val logger = Logger("BaseUseCaseExecutor")

    open fun <O> execute(
        useCase: UseCase<Unit, O>,
        callback: (O) -> Unit = {},
        error: (Exception) -> Unit = {}
    ) = execute(useCase, Unit, callback, error)

    open fun <I, O> execute(
        useCase: UseCase<I, O>,
        value: I,
        callback: (O) -> Unit = {},
        error: (Exception) -> Unit = {}
    ): RunningExecution {
        val job = executeUseCase(useCase, value, callback, error)
        return RunningUseCaseExecution(job)
    }

    private fun <I, O> executeUseCase(
        useCase: UseCase<I, O>,
        value: I,
        callback: (O) -> Unit,
        error: (Exception) -> Unit
    ) = coroutineScope.launch {
        val callbackWrapper = { result: O ->
            callback(result)
        }
        try {
            useCase.execute(value, callbackWrapper)
        } catch (cancellationException: CancellationException) {
            // Log Error
            logger.log(cancellationException.message ?: "Unknown Error")
        } catch (throwable: Throwable) {
            // Log Error
            logger.log(throwable.message ?: "Unknown Error")
            error(
                if (throwable is Exception) {
                    throwable
                } else {
                    useCase.onError(throwable)
                }
            )
        }
    }

    class RunningUseCaseExecution(private val job: Job) : RunningExecution {
        override fun isRunning() = job.isActive

        override fun cancel() {
            job.cancel()
        }
    }
}

interface UseCase<I, O> {
    suspend fun execute(input: I, callback: (O) -> Unit)

    fun onError(throwable: Throwable): Exception = Exception(throwable)
}
