package com.cache.cache.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CacheServiceTest {

    @Test
    void testCacheFunctionality() throws InterruptedException {
        CacheService cacheService = new CacheService();

        // Ajouter une valeur
        cacheService.putInCache("testKey", "testValue");

        // Vérifier que la valeur est bien en cache
        assertEquals("testValue", cacheService.getFromCache("testKey"));

        // Attendre plus de 10 secondes pour l'expiration
        Thread.sleep(11000);

        // Vérifier que la valeur a été supprimée automatiquement
        assertNull(cacheService.getFromCache("testKey"));
    }
}
