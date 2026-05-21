package com.mathisdulieu.ticketing.gateway.eventapi.response;

import lombok.Builder;

import java.util.List;

@Builder
public record EventApiResponse(
    String code,
    List<String> errors
) {}
