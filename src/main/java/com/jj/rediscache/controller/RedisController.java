package com.jj.rediscache.controller;

import com.jj.rediscache.service.RedisService;
import lombok.RequiredArgsConstructor;
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
}
