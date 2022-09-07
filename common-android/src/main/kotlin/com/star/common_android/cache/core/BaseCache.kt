package com.star.common_android.cache.core

import com.star.common_android.cache.Cache
import com.star.common_android.cache.model.CacheData
import com.star.common_android.cache.source.CacheSource
import com.star.common_android.cache.policy.CachePolicy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseCache<K, V>(
    private val cacheSource: CacheSource<K, V>,
) : Cache<K, V>,
    CoroutineScope by CoroutineScope(Dispatchers.IO) {

    override val cachePolicies: List<CachePolicy<V>> = emptyList()

    override val size: Int
        get() = cacheSource.size

    override fun clear() {
        cacheSource.clear()
    }

    override fun delete(key: K) {
        cacheSource.deleteCache(key)
    }

    override fun set(key: K, value: V) {
        cacheSource[key] = cacheSource.createCacheData(value)
    }

    override fun get(key: K): CacheData<out V>? = cacheSource[key]

    override fun getWithPolicies(key: K): V? {
        val cachedData = get(key)
        return if (cachedData != null  && isValidCache(cachedData)) {
            cachedData.data
        } else null
    }

    override suspend fun getWithSource(key: K, source: suspend () -> V): V? {
        val cachedData = get(key)
        return if (cachedData != null && isValidCache(cachedData)) {
            cachedData.data
        } else getFromSource(source, key)
    }

    private fun isValidCache(result: CacheData<out  V>?): Boolean =
        cachePolicies.isEmpty() || cachePolicies.all { it.isNotExpired(result) }

    private suspend fun getFromSource(source: suspend () -> V, key: K): V? {
        val result = source()
        set(key, result)
        return result
    }
}