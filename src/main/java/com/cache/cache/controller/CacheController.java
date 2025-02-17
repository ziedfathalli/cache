package com.cache.cache.controller;

import com.cache.cache.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {
    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/{key}")
    public void putInCache(@PathVariable String key, @RequestBody String value) {
        cacheService.putInCache(key, value);
    }

    @GetMapping("/{key}")
    public String getFromCache(@PathVariable String key) {
        return cacheService.getFromCache(key);
    }

    @DeleteMapping("/{key}")
    public void removeFromCache(@PathVariable String key) {
        cacheService.removeFromCache(key);
    }
}
