package com.mathisdulieu.ticketing.gateway.inventoryapi;

import com.mathisdulieu.ticketing.library.api.inventory.InventoryApiClient;
import com.mathisdulieu.ticketing.library.api.inventory.InventoryApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryApiService {

    private final InventoryApiClient inventoryApiClient;

    public ResponseEntity<InventoryApiResponse> doSomething() {
        return inventoryApiClient.get("/get/any");
    }

}
