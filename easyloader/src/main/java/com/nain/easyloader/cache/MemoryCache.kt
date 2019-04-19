package com.nain.easyloader.cache

import kotlin.collections.HashMap

/**
 * @author julkar nain
 * @since 4/18/19
 */
internal object MemoryCache {
    private var maxCacheSize = 0
    private var cache : MutableMap<String, CacheItem> = HashMap()

    fun get(url: String): Any?{
        if(cache.containsKey(url)){
            val cacheItem = cache.get(url) as CacheItem
            return cacheItem.item
        }else{
            return null
        }
    }

    fun set(url: String, item: Any) {
        if (cache.size >= maxCacheSize){
            clearLessUsedItemFromCache()
        }

       cache.put(url, CacheItem(item, System.currentTimeMillis()))
    }

    fun setMaxCacheSize(maxSize : Int){
        maxCacheSize = maxSize
    }

    fun clear(){
        cache.clear()
    }

    private fun clearLessUsedItemFromCache(){
        var lastTime : Long = System.currentTimeMillis()
        var lastKey = ""

        for (key : String in cache.keys){
            val item : CacheItem = cache.get(key) as CacheItem

            if (lastTime > item.lastUsed){
                lastTime = item.lastUsed
                lastKey = key;
            }
        }

        cache.remove(lastKey)
    }
}