package com.star.common_android.cache

import com.star.common_android.cache.model.CacheData
import com.star.common_android.cache.policy.CachePolicy

interface Cache<K, V> {
    val cachePolicies: List<CachePolicy<V>>
    val size: Int

    fun clear()
    fun delete(key: K)
    fun set(
        key: K,
        value: V
    )

    fun get(key: K): CacheData<out V>?
    fun getWithPolicies(key: K): V?
    suspend fun getWithSource(
        key: K,
        source: suspend () -> V
    ): V?
}