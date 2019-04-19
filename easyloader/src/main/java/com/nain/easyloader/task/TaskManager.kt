package com.nain.easyloader.task

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

object TaskManager {
    private val executorService: ExecutorService = Executors.newCachedThreadPool()

    // Every task works asynchronously with individual thread
    fun addTask(task: Runnable): Future<*> {
        return executorService.submit(task) as Future<*>
    }

    fun cancelTask(task: Future<*>) {
        task.cancel(true)
    }

    fun cancelAllTasks() {
        executorService.shutdownNow()
    }
}