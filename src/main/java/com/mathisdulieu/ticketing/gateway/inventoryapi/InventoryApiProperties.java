package com.mathisdulieu.ticketing.gateway.inventoryapi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static org.springframework.util.Assert.hasText;

@ConfigurationProperties(prefix = "inventory-api")
public record InventoryApiProperties(
    String baseUrl
) implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        hasText(baseUrl, "inventory-api.baseUrl must be given");
    }
}
