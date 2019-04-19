package com.nain.easyloader.builder

import com.nain.easyloader.cache.MemoryCache
import com.nain.easyloader.loader.BaseLoader

@Suppress("UNCHECKED_CAST")
open class BaseBuilder<P, Q>(internal val baseLoader: BaseLoader) {
    open fun src(url: String): P {
        baseLoader.url = url

        return this as P
    }

    open fun cacheLimit(maxLimit: Int): P {
        MemoryCache.setMaxCacheSize(maxLimit)

        return this as P
    }

    open fun build(): Q {
        return baseLoader as Q
    }
}