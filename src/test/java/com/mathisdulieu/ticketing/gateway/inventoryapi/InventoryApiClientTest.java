package com.mathisdulieu.ticketing.gateway.inventoryapi;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.mathisdulieu.ticketing.gateway.inventoryapi.response.InventoryApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@WireMockTest(httpPort = 8090)
class InventoryApiClientTest {

    @Autowired
    private InventoryApiClient inventoryApiClient;

    @Test
    void shouldSendRequestToInventoryApiAndReturnInventoryApiInfos() {
        // Arrange
        stubFor(get("/inventory/api/v1/example").willReturn(ok()
            .withHeader("Content-Type", "application/json")
            .withBody("""
                {
                    "code": "anyCode",
                    "errors": [
                        "anyError1",
                        "anyError2"
                    ]
                }
                """)
        ));

        // Act
        ResponseEntity<InventoryApiResponse> inventoryApiResponse = inventoryApiClient.doSomething();

        // Assert
        InventoryApiResponse expectedInventoryApiResponseBody = InventoryApiResponse.builder()
            .code("anyCode")
            .errors(List.of("anyError1", "anyError2"))
            .build();

        assertThat(inventoryApiResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(inventoryApiResponse.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(inventoryApiResponse.getBody()).isEqualTo(expectedInventoryApiResponseBody);
    }

}
