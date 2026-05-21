package com.mathisdulieu.ticketing.gateway.reservationapi;

import com.mathisdulieu.ticketing.gateway.reservationapi.response.ReservationApiResponse;
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
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationApiController {

    private final ReservationApiService reservationApiService;

    @GetMapping("/example")
    @Operation(summary = "Example reservation endpoint", description = "Returns a confirmation message")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<ReservationApiResponse> doSomething() {
        log.debug("Received request: GET /api/v1/reservations/example");
        return reservationApiService.doSomething();
    }

}
