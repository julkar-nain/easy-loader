package com.nain.easyloader

import com.nain.easyloader.builder.ImageBuilder
import com.nain.easyloader.builder.JsonBuilder
import com.nain.easyloader.cache.MemoryCache
import com.nain.easyloader.task.TaskManager

/**
 * @author julkar nain
 * @since 4/18/19
 */
object EasyLoader {
    fun imageBuilder(): ImageBuilder {
        return ImageBuilder()
    }

    fun jsonBuilder(): JsonBuilder{
        return JsonBuilder()
    }

    fun clearCache(){
        MemoryCache.clear()
    }

    fun cancelAllTasks(){
        TaskManager.cancelAllTasks()
    }
}