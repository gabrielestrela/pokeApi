package com.star.pokedex.data.datasource.local

import com.star.common_android.cache.core.lru.LruCache
import com.star.common_android.cache.policy.CachePolicy
import com.star.common_android.cache.policy.ExpirationTimeCachePolicy
import com.star.pokedex.data.response.PokedexListItemResponse
import java.util.concurrent.TimeUnit

class PokedexCache : LruCache<String,PokedexListItemResponse>() {
    override val cachePolicies: List<CachePolicy<PokedexListItemResponse>> = policies

    companion object {
        private val policies: List<ExpirationTimeCachePolicy<PokedexListItemResponse>> =
            listOf(ExpirationTimeCachePolicy(5, TimeUnit.MINUTES))
        const val POKEMON_LIST_KEY = "POKEMON_LIST_KEY"
    }
}
