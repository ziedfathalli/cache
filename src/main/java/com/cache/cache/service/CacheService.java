package com.cache.cache.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {
    private static class CacheEntry {
        String value;
        long expiryTime;

        CacheEntry(String value, long ttl) {
            this.value = value;
            this.expiryTime = System.currentTimeMillis() + ttl;
        }
    }

    private final Map<String, CacheEntry> cache = new ConcurrentHashMap<>();
    @Value("${cache.ttl}") // Récupère le TTL depuis application.properties
    private long TTL;

    public void putInCache(String key, String value) {
        cache.put(key, new CacheEntry(value, TTL));
    }

    public String getFromCache(String key) {
        CacheEntry entry = cache.get(key);
        if (entry == null || entry.expiryTime < System.currentTimeMillis()) {
            cache.remove(key);
            return null; // Expiré ou absent
        }
        return entry.value;
    }

    public void removeFromCache(String key) {
        cache.remove(key);
    }

    // Vérifie et nettoie les entrées expirées toutes les 5 secondes
    @Scheduled(fixedRate = 5000)
    public void cleanUpCache() {
        long now = System.currentTimeMillis();
        cache.entrySet().removeIf(entry -> entry.getValue().expiryTime < now);
    }
}
