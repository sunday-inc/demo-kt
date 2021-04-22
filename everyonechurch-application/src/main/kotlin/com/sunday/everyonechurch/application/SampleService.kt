package com.sunday.everyonechurch.application

import com.sunday.everyonechurch.infra.cache.local.LOCAL_SAMPLE_CACHE_NAME
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@CacheConfig(cacheNames = [LOCAL_SAMPLE_CACHE_NAME])
class SampleService {
    @Cacheable(key = "'sample:' + #id")
    fun getSampleValue(id: Long) : String {
        return "Value-$id"
    }
}
