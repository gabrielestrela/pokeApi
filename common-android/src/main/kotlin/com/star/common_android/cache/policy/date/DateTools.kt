package com.star.common_android.cache.policy.date

import java.util.*
import java.util.concurrent.TimeUnit

private const val NANOSECONDS_ERROR = "NANOSECONDS is not supported from cache"
private const val MICROSECONDS_ERROR = "MICROSECONDS is not supported from cache"

internal fun today(
    timeZone: TimeZone = TimeZone.getDefault()
): Calendar = Calendar.getInstance(timeZone)

internal fun Date.toCalendar(timeZone: TimeZone = TimeZone.getDefault()): Calendar =
    Calendar.getInstance(timeZone).apply { time = this@toCalendar }

internal fun TimeUnit.convertToInt(): Int = when (this) {
    TimeUnit.NANOSECONDS -> throw RuntimeException(NANOSECONDS_ERROR)
    TimeUnit.MICROSECONDS -> throw RuntimeException(MICROSECONDS_ERROR)
    TimeUnit.MILLISECONDS -> Calendar.MILLISECOND
    TimeUnit.SECONDS -> Calendar.SECOND
    TimeUnit.MINUTES -> Calendar.MINUTE
    TimeUnit.HOURS -> Calendar.HOUR
    TimeUnit.DAYS -> Calendar.DAY_OF_YEAR
}