package com.mathisdulieu.ticketing.gateway.reservationapi;

import com.mathisdulieu.ticketing.library.api.reservation.ReservationApiClient;
import com.mathisdulieu.ticketing.library.api.reservation.ReservationApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationApiService {

    private final ReservationApiClient reservationApiClient;

    public ResponseEntity<ReservationApiResponse> doSomething() {
        return reservationApiClient.get("/get/any");
    }
}
