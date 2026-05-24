package com.mathisdulieu.ticketing.gateway.inventoryapi;

import com.mathisdulieu.ticketing.library.api.inventory.InventoryApiClient;
import com.mathisdulieu.ticketing.library.api.inventory.InventoryApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryApiServiceTest {

    @Mock
    private InventoryApiClient inventoryApiClient;
    @InjectMocks
    private InventoryApiService inventoryApiService;

    @Test
    void shouldCallInventoryApiClient() {
        // Arrange
        InventoryApiResponse inventoryApiResponse = InventoryApiResponse.builder()
            .code("any")
            .errors(List.of("any1", "any2"))
            .build();

        when(inventoryApiClient.get(anyString())).thenReturn(ResponseEntity.ok(inventoryApiResponse));

        // Act
        ResponseEntity<InventoryApiResponse> inventoryApiResponseResponseEntity = inventoryApiService.doSomething();

        // Assert
        assertThat(inventoryApiResponseResponseEntity).isEqualTo(ResponseEntity.ok(inventoryApiResponse));
        verify(inventoryApiClient).get("/get/any");
    }

}
