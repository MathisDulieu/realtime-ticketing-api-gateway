package com.mathisdulieu.ticketing.gateway;

import com.mathisdulieu.ticketing.gateway.config.CorsProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@TestConfiguration
public class RealtimeTicketingApiGatewayConfigurationTests {

    @Bean
    public CorsProperties corsProperties() {
        return new CorsProperties(
                List.of("http://localhost:3000"),
                List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"),
                List.of("*"),
                true,
                3600L
        );
    }

}
