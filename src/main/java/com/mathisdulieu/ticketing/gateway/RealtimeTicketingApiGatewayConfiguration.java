package com.mathisdulieu.ticketing.gateway;

import com.mathisdulieu.ticketing.gateway.eventapi.EventApiProperties;
import com.mathisdulieu.ticketing.gateway.inventoryapi.InventoryApiProperties;
import com.mathisdulieu.ticketing.gateway.reservationapi.ReservationApiProperties;
import com.mathisdulieu.ticketing.library.api.event.EventApiClient;
import com.mathisdulieu.ticketing.library.api.inventory.InventoryApiClient;
import com.mathisdulieu.ticketing.library.api.reservation.ReservationApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RealtimeTicketingApiGatewayConfiguration {

    @Bean
    public RestClient restClient() {
        return RestClient.builder().build();
    }

    @Bean
    public EventApiClient eventApiClient(RestClient restClient, EventApiProperties eventApiProperties) {
        return new EventApiClient(restClient, eventApiProperties.baseUrl());
    }

    @Bean
    public InventoryApiClient inventoryApiClient(RestClient restClient, InventoryApiProperties inventoryApiProperties) {
        return new InventoryApiClient(restClient, inventoryApiProperties.baseUrl());
    }

    @Bean
    public ReservationApiClient reservationApiClient(RestClient restClient, ReservationApiProperties reservationApiProperties) {
        return new ReservationApiClient(restClient, reservationApiProperties.baseUrl());
    }

}
