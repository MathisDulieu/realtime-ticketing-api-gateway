package com.mathisdulieu.ticketing.gateway.eventapi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static org.springframework.util.Assert.hasText;

@ConfigurationProperties(prefix = "event-api")
public record EventApiProperties(
    String baseUrl
) implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        hasText(baseUrl, "event-api.baseUrl must be given");
    }
}
