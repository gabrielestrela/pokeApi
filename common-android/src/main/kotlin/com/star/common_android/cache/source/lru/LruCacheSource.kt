package com.star.common_android.cache.source.lru

import com.star.common_android.cache.model.CacheData
import com.star.common_android.cache.source.CacheSource

private const val DEFAULT_SIZE = 4 * 1024 * 1024

class LruCacheSource<K, V> (cacheSize: Int = DEFAULT_SIZE) : CacheSource<K, V> {

    private val memoryCache: androidx.collection.LruCache<K, CacheData<out V>> =
        androidx.collection.LruCache(cacheSize)

    override val size: Int
        get() = memoryCache.size()

    override fun clear() {
        memoryCache.evictAll()
    }

    override fun deleteCache(key: K) {
        memoryCache.remove(key)
    }

    override fun createCacheData(value: V): CacheData<out V> = CacheData(value)

    override fun get(key: K): CacheData<out V>? = memoryCache.get(key)

    override fun set(key: K, value: CacheData<out V>) {
        memoryCache.put(key, value)
    }
}
