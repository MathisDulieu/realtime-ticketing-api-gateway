package com.mathisdulieu.ticketing.gateway.reservationapi;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.mathisdulieu.ticketing.gateway.reservationapi.response.ReservationApiResponse;
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
class ReservationApiClientTest {

    @Autowired
    private ReservationApiClient reservationApiClient;

    @Test
    void shouldSendRequestToReservationApiAndReturnReservationApiInfos() {
        // Arrange
        stubFor(get("/reservation/api/v1/example").willReturn(ok()
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
        ResponseEntity<ReservationApiResponse> reservationApiResponse = reservationApiClient.doSomething();

        // Assert
        ReservationApiResponse expectedReservationApiResponseBody = ReservationApiResponse.builder()
            .code("anyCode")
            .errors(List.of("anyError1", "anyError2"))
            .build();

        assertThat(reservationApiResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(reservationApiResponse.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(reservationApiResponse.getBody()).isEqualTo(expectedReservationApiResponseBody);
    }

}
