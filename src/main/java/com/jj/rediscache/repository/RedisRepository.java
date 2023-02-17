package com.jj.rediscache.repository;

import com.jj.rediscache.model.entity.Food;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RedisRepository implements FoodRepository {
    private final RedisOperations<String, Object> operations;

    @Override
    public void save(Food food) {
        operations.opsForValue().set(food.getName(), food);
        log.info("Saved " + food.getName());
    }

    @Override
    public Food get(String name) {
        Food food = (Food) operations.opsForValue().get(name);
        return food;
    }

    @Override
    public List<Food> getAll() {
        List<Food> foodList = operations.keys("*")
                .stream()
                .map(key -> (Food)operations.opsForValue().get(key))
                .toList();

        return foodList;
    }

    @Override
    public void remove(String key) {
        if (existsByKey(key)) {
            operations.delete(key);
        }
    }

    @Override
    public boolean existsByKey(String key) {
        return operations.hasKey(key);
    }
}
