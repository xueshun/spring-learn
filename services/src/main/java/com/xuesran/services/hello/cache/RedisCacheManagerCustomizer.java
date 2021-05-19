package com.xuesran.services.hello.cache;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * The type Redis cache manager customizer.
 *
 * @author xueshun
 */
public class RedisCacheManagerCustomizer implements CacheManagerCustomizer<RedisCacheManager> {
    @Override
    public void customize(RedisCacheManager cacheManager) {

    }
}
