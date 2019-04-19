package com.nain.easyloader

import com.nain.easyloader.builder.ImageBuilder
import com.nain.easyloader.cache.MemoryCache

/**
 * @author julkar nain
 * @since 4/18/19
 */
object EasyLoader {
    fun imageBuilder(): ImageBuilder {
        return ImageBuilder();
    }

    fun clearCache(){
        MemoryCache.clear()
    }
}