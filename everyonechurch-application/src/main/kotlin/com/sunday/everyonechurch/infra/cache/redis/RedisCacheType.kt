package com.sunday.everyonechurch.infra.cache.redis

import java.time.Duration

const val SAMPLE_CACHE_NAME = "sample"

enum class RedisCacheType(
        val cacheName: String, val expiredAfterWrite: Long
) {
    SAMPLE(SAMPLE_CACHE_NAME, Duration.ofDays(1).seconds),
}
