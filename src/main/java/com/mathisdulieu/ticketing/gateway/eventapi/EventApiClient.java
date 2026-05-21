package com.mathisdulieu.ticketing.gateway.eventapi;

import com.mathisdulieu.ticketing.gateway.eventapi.response.EventApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventApiClient {

    private final RestClient restClient;
    private final EventApiProperties eventApiProperties;

    public ResponseEntity<EventApiResponse> doSomething() {
        log.debug("Calling event-service: GET /api/v1/example");
        return restClient.get()
            .uri(eventApiProperties.baseUrl() + "/api/v1/example")
            .retrieve()
            .toEntity(EventApiResponse.class);
    }
}
