package com.mathisdulieu.ticketing.gateway.inventoryapi.response;

import lombok.Builder;

import java.util.List;

@Builder
public record InventoryApiResponse(
    String code,
    List<String> errors
) {}
