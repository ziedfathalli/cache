package com.cache.cache.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CacheControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCacheEndpoints() throws Exception {
        // Ajouter une valeur en cache
        mockMvc.perform(post("/cache/testKey")
                        .contentType("text/plain")
                        .content("testValue"))
                .andExpect(status().isOk());

        // Récupérer la valeur
        mockMvc.perform(get("/cache/testKey"))
                .andExpect(status().isOk())
                .andExpect(content().string("testValue"));

        // Supprimer la valeur
        mockMvc.perform(delete("/cache/testKey"))
                .andExpect(status().isOk());

        // Vérifier que la valeur est bien supprimée
        mockMvc.perform(get("/cache/testKey"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}

