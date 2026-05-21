package com.mathisdulieu.ticketing.gateway.inventoryapi;

import com.mathisdulieu.ticketing.gateway.inventoryapi.response.InventoryApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryApiClient {

    private final RestClient restClient;
    private final InventoryApiProperties inventoryApiProperties;

    public ResponseEntity<InventoryApiResponse> doSomething() {
        log.debug("Calling inventory-service: GET /api/v1/example");
        return restClient.get()
            .uri(inventoryApiProperties.baseUrl() + "/api/v1/example")
            .retrieve()
            .toEntity(InventoryApiResponse.class);
    }
}
