package com.mathisdulieu.ticketing.gateway.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class HealthService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${app.version}")
    private String applicationVersion;

    @Value("${app.environment}")
    private String environment;

    public Map<String, Object> getHealthInfo() {
        return Map.of(
                "status", "UP",
                "application", applicationName,
                "version", applicationVersion,
                "environment", environment,
                "timestamp", Instant.now().toString()
        );
    }
}
