package com.star.common_android.cache.source

import com.star.common_android.cache.model.CacheData

interface CacheSource<K, V> {
    val size: Int

    fun createCacheData(value: V): CacheData<out V>

    fun clear()

    fun deleteCache(key: K)

    operator fun get(key: K): CacheData<out V>?

    operator fun set(
        key: K,
        value: CacheData<out V>
    )
}