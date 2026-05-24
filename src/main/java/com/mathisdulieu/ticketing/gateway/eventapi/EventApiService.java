package com.mathisdulieu.ticketing.gateway.eventapi;

import com.mathisdulieu.ticketing.library.api.event.EventApiClient;
import com.mathisdulieu.ticketing.library.api.event.EventApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventApiService {

    private final EventApiClient eventApiClient;

    public ResponseEntity<EventApiResponse> doSomething() {
        return eventApiClient.get("/get/any");
    }
}
