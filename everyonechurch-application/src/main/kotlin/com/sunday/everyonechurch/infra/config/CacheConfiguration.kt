package com.sunday.everyonechurch.infra.config

import com.github.benmanes.caffeine.cache.Caffeine
import com.sunday.everyonechurch.infra.cache.local.LocalCacheType
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit


@Configuration
@EnableCaching
class CacheConfiguration {
    @Bean
    fun localCacheManager(): CacheManager = SimpleCacheManager().apply {
        setCaches(
                LocalCacheType.values().asSequence().map { c ->
                    CaffeineCache(c.cacheName, Caffeine.newBuilder()
                            .expireAfterWrite(c.expiredAfterWrite, TimeUnit.SECONDS)
                            .maximumSize(c.maximumSize).recordStats()
                            .build()
                    )
                }.toList()
        )
    }

//    @Autowired
//    lateinit var redisConnectionFactory: RedisConnectionFactory
//
//    @Bean
//    fun redisCacheManager(): CacheManager {
//        val objectMapper = jacksonObjectMapper().registerModule(JavaTimeModule())
//                .enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY)
//
//        val redisCacheConfigurationMap = RedisCacheType.values().map { c ->
//            c.cacheName to RedisCacheConfiguration.defaultCacheConfig()
//                    .prefixKeysWith(c.cacheName + "-")
//                    .serializeValuesWith(RedisSerializationContext.SerializationPair
//                            .fromSerializer(GenericJackson2JsonRedisSerializer(objectMapper)))
//                    .entryTtl(Duration.ofSeconds(c.expiredAfterWrite))
//        }.toMap()
//
//        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
//                .withInitialCacheConfigurations(redisCacheConfigurationMap).build()
//    }
//
//    @Bean
//    @Primary
//    fun cacheManager(): CacheManager {
//        return CompositeCacheManager(localCacheManager(), redisCacheManager())
//    }
}
