package com.mathisdulieu.ticketing.gateway.eventapi;

import com.mathisdulieu.ticketing.gateway.eventapi.response.EventApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventApiService {

    private final EventApiClient eventApiClient;

    public ResponseEntity<EventApiResponse> doSomething() {
        return eventApiClient.doSomething();
    }
}
