package com.star.common_android.cache.policy

import com.star.common_android.cache.model.CacheData
import com.star.common_android.cache.policy.date.convertToInt
import com.star.common_android.cache.policy.date.toCalendar
import com.star.common_android.cache.policy.date.today
import java.util.*
import java.util.concurrent.TimeUnit

class ExpirationTimeCachePolicy<V>(
    private val duration: Int,
    private val timeUnit: TimeUnit
) : CachePolicy<V> {
    override fun isNotExpired(cacheData: CacheData<out V>?): Boolean = cacheData?.let { data ->
        data.createdAt.isValidDate(duration, timeUnit)
    } ?: false

    private fun Date.isValidDate(
        duration: Int,
        timeUnit: TimeUnit
    ): Boolean {
        val currentDate = today()
        val expiredDate = this.toCalendar().apply {
            add(timeUnit.convertToInt(), duration)
        }

        return currentDate.before(expiredDate)
    }
}
