package com.sunday.everyonechurch.infra.cache.local

import java.time.Duration

const val LOCAL_SAMPLE_CACHE_NAME = "sample"

enum class LocalCacheType(
        val cacheName: String, val expiredAfterWrite: Long, val maximumSize: Long
) {
    SAMPLE(LOCAL_SAMPLE_CACHE_NAME, Duration.ofMinutes(2).seconds, 5000),
}
