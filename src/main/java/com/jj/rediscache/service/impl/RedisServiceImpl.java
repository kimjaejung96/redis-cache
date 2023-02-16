package com.jj.rediscache.service.impl;

import com.jj.rediscache.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisServiceImpl implements RedisService {
    private final StringRedisTemplate redisTemplate;
    @Override
    public void getRedisStringValues(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        log.info("\n[get]redis key : {}\n[get]redis value : {}", key, valueOperations.get(key));
    }

    @Override
    public void pushRedisStringKeyValues(String key, String value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
        log.info("\n[set]redis key : {}\n[set]redis value : {}", key, valueOperations.get(key));
    }
}
