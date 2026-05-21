package com.mathisdulieu.ticketing.gateway.reservationapi;

import com.mathisdulieu.ticketing.gateway.reservationapi.response.ReservationApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReservationApiClient {

    private final RestClient restClient;
    private final ReservationApiProperties reservationApiProperties;

    public ResponseEntity<ReservationApiResponse> doSomething() {
        log.debug("Calling reservation-service: GET /api/v1/example");
        return restClient.get()
            .uri(reservationApiProperties.baseUrl() + "/api/v1/example")
            .retrieve()
            .toEntity(ReservationApiResponse.class);
    }
}
