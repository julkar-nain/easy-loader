package com.nain.easyloader.cache

/**
 * @author julkar nain
 * @since 4/18/19
 */
internal object MemoryCache {
    // default cache value is 100
    private var maxCacheSize = 100
    private var cache = LinkedHashMap<String, CacheItem>()

    fun get(url: String): Any?{
        if(cache.containsKey(url)){
            val cacheItem = cache.get(url) as CacheItem
            cacheItem.lastUsed = System.currentTimeMillis()
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