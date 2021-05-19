package com.xuesran.services.hello.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The type Cache redis caffeine properties.
 *
 * @author xueshun
 */
@ConfigurationProperties(prefix = "spring.cache.multi")
public class CacheRedisCaffeineProperties {
    private Set<String> cacheNames = new HashSet<>();
    /**
     * Whether to store null value.
     * The default value is true to prevent cache penetration
     */
    private boolean cacheNullValues = true;
    /**
     * Whether to dynamically create the implementation of Cache according to the cacheName.
     * The default value is true
     */
    private boolean dynamic = true;

    /**
     * Prefix of cache key
     */
    private String cachePrefix;

    private Redis redis = new Redis();
    private Caffeine caffeine = new Caffeine();


    public static class Redis {
        /**
         * Global expiration time, in milliseconds. It does not expire by default
         */
        private long defaultExpiration = 0;

        /**
         * The expiration time of each cacheName, in milliseconds, has a higher priority than the default expiration
         */
        private Map<String, Long> expires = new HashMap<>();

        /**
         * topic name to notify other nodes when cache updates
         */
        private String topic = "cache:redis:caffeine:topic";

        public long getDefaultExpiration() {
            return defaultExpiration;
        }

        public void setDefaultExpiration(long defaultExpiration) {
            this.defaultExpiration = defaultExpiration;
        }

        public Map<String, Long> getExpires() {
            return expires;
        }

        public void setExpires(Map<String, Long> expires) {
            this.expires = expires;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

    }

    public static class Caffeine {
        /**
         * Expiration time after access, in milliseconds
         */
        private long expireAfterAccess;

        /**
         * Expiration time after writing, in milliseconds
         */
        private long expireAfterWrite;

        /**
         * Refresh time after writing, in milliseconds
         */
        private long refreshAfterWrite;

        /**
         * Initialization size
         */
        private int initialCapacity;

        /**
         * The maximum number of cache objects. If this number is exceeded, the previous cache will be invalid
         */
        private long maximumSize;

        /**
         * Since the weight needs to be provided by cache objects, it is not suitable for using spring cache, so configuration is not supported for the moment
         */
        public long getExpireAfterAccess() {
            return expireAfterAccess;
        }

        public void setExpireAfterAccess(long expireAfterAccess) {
            this.expireAfterAccess = expireAfterAccess;
        }

        public long getExpireAfterWrite() {
            return expireAfterWrite;
        }

        public void setExpireAfterWrite(long expireAfterWrite) {
            this.expireAfterWrite = expireAfterWrite;
        }

        public long getRefreshAfterWrite() {
            return refreshAfterWrite;
        }

        public void setRefreshAfterWrite(long refreshAfterWrite) {
            this.refreshAfterWrite = refreshAfterWrite;
        }

        public int getInitialCapacity() {
            return initialCapacity;
        }

        public void setInitialCapacity(int initialCapacity) {
            this.initialCapacity = initialCapacity;
        }

        public long getMaximumSize() {
            return maximumSize;
        }

        public void setMaximumSize(long maximumSize) {
            this.maximumSize = maximumSize;
        }
    }

    public Set<String> getCacheNames() {
        return cacheNames;
    }

    public void setCacheNames(Set<String> cacheNames) {
        this.cacheNames = cacheNames;
    }

    public boolean isCacheNullValues() {
        return cacheNullValues;
    }

    public void setCacheNullValues(boolean cacheNullValues) {
        this.cacheNullValues = cacheNullValues;
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    public String getCachePrefix() {
        return cachePrefix;
    }

    public void setCachePrefix(String cachePrefix) {
        this.cachePrefix = cachePrefix;
    }

    public Redis getRedis() {
        return redis;
    }

    public void setRedis(Redis redis) {
        this.redis = redis;
    }

    public Caffeine getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(Caffeine caffeine) {
        this.caffeine = caffeine;
    }
}
