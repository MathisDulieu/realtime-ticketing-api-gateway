package com.mathisdulieu.ticketing.gateway.inventoryapi;

import com.mathisdulieu.ticketing.gateway.inventoryapi.response.InventoryApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryApiService {

    private final InventoryApiClient inventoryApiClient;

    public ResponseEntity<InventoryApiResponse> doSomething() {
        return inventoryApiClient.doSomething();
    }

}
