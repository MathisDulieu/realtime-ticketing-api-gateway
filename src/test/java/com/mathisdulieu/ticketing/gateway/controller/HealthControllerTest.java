package com.mathisdulieu.ticketing.gateway.controller;

import com.mathisdulieu.ticketing.gateway.service.HealthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HealthController.class)
@ActiveProfiles("test")
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HealthService healthService;

    @Test
    void shouldReturn200WithHealthInfo() throws Exception {
        // Arrange
        Map<String, Object> healthInfo = Map.of(
                "status", "UP",
                "application", "realtime-ticketing-api-gateway",
                "timestamp", "2025-01-01T00:00:00Z"
        );

        when(healthService.getHealthInfo()).thenReturn(healthInfo);

        // Act & Assert
        mockMvc.perform(get("/api/v1/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.application").value("realtime-ticketing-api-gateway"));
    }
}
