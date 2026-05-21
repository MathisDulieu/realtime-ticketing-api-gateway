package com.mathisdulieu.ticketing.gateway.reservationapi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static org.springframework.util.Assert.hasText;

@ConfigurationProperties(prefix = "reservation-api")
public record ReservationApiProperties(
    String baseUrl
) implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        hasText(baseUrl, "reservation-api.baseUrl must be given");
    }
}
