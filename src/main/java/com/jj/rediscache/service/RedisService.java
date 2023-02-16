package com.jj.rediscache.service;

public interface RedisService {
    void getRedisStringValues(String key);
    void pushRedisStringKeyValues(String key, String value);
}
