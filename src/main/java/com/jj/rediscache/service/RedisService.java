package com.jj.rediscache.service;

import com.jj.rediscache.model.entity.Food;

public interface RedisService {
    void getRedisStringValues(String key);
    void pushRedisStringKeyValues(String key, String value);
    void save(Food food);
    Food get(String name);
    void getAll();
    void remove(String name);
}
