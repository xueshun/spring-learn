package com.xuesran.services.hello.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Cache redis configuration.
 *
 * @author xueshun
 */
@Configuration
public class CacheRedisConfiguration {

    @Bean
    public RedisCacheManagerCustomizer redisCacheManagerCustomizer(){
        return new RedisCacheManagerCustomizer();
    }
}
