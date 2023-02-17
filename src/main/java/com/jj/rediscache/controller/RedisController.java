package com.jj.rediscache.controller;

import com.jj.rediscache.model.entity.Food;
import com.jj.rediscache.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RedisController {
    private final RedisService redisService;

    @GetMapping("/{key}")
    public void getRedisValue(@PathVariable String key) {
        redisService.getRedisStringValues(key);
    }
    @PostMapping("/{key}")
    public void pushRedisValue(@PathVariable String key, @RequestParam String value) {
        redisService.pushRedisStringKeyValues(key, value);
    }
    @PostMapping("/redis/save")
    public ResponseEntity<HttpStatusCode> save(@RequestBody Food food) {
        redisService.save(food);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/redis/key/{name}")
    public ResponseEntity<Food> get(@PathVariable String name) {
        Food food = redisService.get(name);
        return ResponseEntity.status(HttpStatus.OK).body(food);
    }
    @GetMapping("/redis/keys")
    public ResponseEntity<HttpStatusCode> getAll() {
        redisService.getAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/redis/keys/{name}")
    public ResponseEntity<HttpStatusCode> remove(@PathVariable String name) {
        redisService.remove(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
