package com.mathisdulieu.ticketing.gateway.reservationapi.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ReservationApiResponse(
    String code,
    List<String> errors
) {}
