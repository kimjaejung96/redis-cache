package com.jj.rediscache.repository;

import com.jj.rediscache.model.entity.Food;

import java.util.List;

public interface FoodRepository {
    void save(Food food);
    Food get(String name);
    List<Food> getAll();
    void remove(String name);
}
