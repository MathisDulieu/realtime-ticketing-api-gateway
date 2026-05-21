package com.mathisdulieu.ticketing.gateway.inventoryapi;

import com.mathisdulieu.ticketing.gateway.inventoryapi.response.InventoryApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryApiController {

    private final InventoryApiService inventoryApiService;

    @GetMapping("/example")
    @Operation(summary = "Example inventory endpoint", description = "Returns a confirmation message")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<InventoryApiResponse> doSomething() {
        log.debug("Received request: GET /api/v1/inventory/example");
        return inventoryApiService.doSomething();
    }

}
