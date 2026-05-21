package com.mathisdulieu.ticketing.gateway.reservationapi;

import com.mathisdulieu.ticketing.gateway.reservationapi.response.ReservationApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationApiService {

    private final ReservationApiClient reservationApiClient;

    public ResponseEntity<ReservationApiResponse> doSomething() {
        return reservationApiClient.doSomething();
    }

}
