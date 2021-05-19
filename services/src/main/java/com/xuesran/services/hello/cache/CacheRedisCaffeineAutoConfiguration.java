package com.xuesran.services.hello.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * The type Cache redis caffeine auto configuration.
 *
 * @author xueshun
 */
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(CacheRedisCaffeineProperties.class)
public class CacheRedisCaffeineAutoConfiguration {

    private final CacheRedisCaffeineProperties cacheRedisCaffeineProperties;

    @Autowired
    public CacheRedisCaffeineAutoConfiguration(final CacheRedisCaffeineProperties cacheRedisCaffeineProperties) {
        this.cacheRedisCaffeineProperties = cacheRedisCaffeineProperties;
    }

    /**
     * Cache manager redis caffeine cache manager.
     *
     * @param redisTemplate the redis template
     * @return the redis caffeine cache manager
     */
    @Bean
    @ConditionalOnBean(RedisTemplate.class)
    public RedisCaffeineCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        return new RedisCaffeineCacheManager(cacheRedisCaffeineProperties, redisTemplate);
    }

    /**
     * Redis message listener container redis message listener container.
     *
     * @param redisTemplate             the redis template
     * @param redisCaffeineCacheManager the redis caffeine cache manager
     * @return the redis message listener container
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisTemplate<Object, Object> redisTemplate,
                                                                       RedisCaffeineCacheManager redisCaffeineCacheManager) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisTemplate.getConnectionFactory());
        CacheMessageListener cacheMessageListener = new CacheMessageListener(redisTemplate, redisCaffeineCacheManager);
        redisMessageListenerContainer.addMessageListener(cacheMessageListener, new ChannelTopic(cacheRedisCaffeineProperties.getRedis().getTopic()));
        return redisMessageListenerContainer;
    }
}