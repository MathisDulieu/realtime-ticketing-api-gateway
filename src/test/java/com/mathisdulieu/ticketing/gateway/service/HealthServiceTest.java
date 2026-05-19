package com.mathisdulieu.ticketing.gateway.service;

import com.mathisdulieu.ticketing.gateway.RealtimeTicketingApiGatewayConfigurationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(RealtimeTicketingApiGatewayConfigurationTests.class)
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
                .containsKey("timestamp");
    }

}
