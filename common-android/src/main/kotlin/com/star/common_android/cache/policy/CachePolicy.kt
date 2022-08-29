package com.star.common_android.cache.policy

import com.star.common_android.cache.model.CacheData

interface CachePolicy<V> {
    fun isNotExpired(cacheData: CacheData<out V>?): Boolean
}
