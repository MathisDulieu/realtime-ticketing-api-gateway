package com.mathisdulieu.ticketing.gateway.eventapi;

import com.mathisdulieu.ticketing.gateway.eventapi.response.EventApiResponse;
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
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventApiController {

    private final EventApiService eventApiService;

    @GetMapping("/example")
    @Operation(summary = "Example event endpoint", description = "Returns a confirmation message")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<EventApiResponse> doSomething() {
        log.debug("Received request: GET /api/v1/events/example");
        return eventApiService.doSomething();
    }
}
