package com.star.common_android.cache.model

import java.util.Calendar
import java.util.Date

data class CacheData<T>(
    val data: T?,
    val createdAt: Date = Calendar.getInstance().time
)
