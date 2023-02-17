package com.jj.rediscache.service;

import com.jj.rediscache.model.entity.Food;

import java.util.List;

public interface RedisService {
    void getRedisStringValues(String key);
    void pushRedisStringKeyValues(String key, String value);
    void save(Food food);
    Food get(String name);
    List<Food> getAll();
    void remove(String name);
}
