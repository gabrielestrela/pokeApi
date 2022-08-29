package com.star.common_android.cache.core.lru

import com.star.common_android.cache.core.BaseCache
import com.star.common_android.cache.source.CacheSource
import com.star.common_android.cache.source.lru.LruCacheSource

abstract class LruCache<K, V>(
    cacheSource: CacheSource<K, V> = LruCacheSource()
) : BaseCache<K, V>(cacheSource)