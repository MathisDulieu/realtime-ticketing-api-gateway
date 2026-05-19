package com.mathisdulieu.ticketing.gateway.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class HealthServiceTest {

    @Autowired
    private HealthService healthService;

    @Test
    void shouldReturnHealthInfos() {
        // Arrange

        // Act
        Map<String, Object> healthInfo = healthService.getHealthInfo();

        // Assert
        assertThat(healthInfo)
                .containsKey("status")
                .containsKey("application")
                .containsKey("version")
                .containsKey("environment")
                .containsKey("timestamp");
    }

}
