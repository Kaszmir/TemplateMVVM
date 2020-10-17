package pl.kaszmir.templatemvvm.fatures.utils

import androidx.arch.core.executor.TaskExecutor

// simulating during test main thread operations
object FakeMainThreadExecutor : TaskExecutor() {

    override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

    override fun isMainThread() = true

    override fun postToMainThread(runnable: Runnable) = runnable.run()
}