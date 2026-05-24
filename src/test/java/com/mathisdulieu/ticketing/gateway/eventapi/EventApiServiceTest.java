package com.mathisdulieu.ticketing.gateway.eventapi;

import com.mathisdulieu.ticketing.library.api.event.EventApiClient;
import com.mathisdulieu.ticketing.library.api.event.EventApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventApiServiceTest {

    @Mock
    private EventApiClient eventApiClient;
    @InjectMocks
    private EventApiService eventApiService;

    @Test
    void shouldCallEventApiClient() {
        // Arrange
        EventApiResponse eventApiResponse = EventApiResponse.builder()
            .code("any")
            .errors(List.of("any1", "any2"))
            .build();

        when(eventApiClient.get(anyString())).thenReturn(ResponseEntity.ok(eventApiResponse));

        // Act
        ResponseEntity<EventApiResponse> eventApiResponseResponseEntity = eventApiService.doSomething();

        // Assert
        assertThat(eventApiResponseResponseEntity).isEqualTo(ResponseEntity.ok(eventApiResponse));
        verify(eventApiClient).get("/get/any");
    }

}
