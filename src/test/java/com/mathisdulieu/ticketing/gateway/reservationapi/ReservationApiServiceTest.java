package com.mathisdulieu.ticketing.gateway.reservationapi;

import com.mathisdulieu.ticketing.library.api.reservation.ReservationApiClient;
import com.mathisdulieu.ticketing.library.api.reservation.ReservationApiResponse;
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
class ReservationApiServiceTest {

    @Mock
    private ReservationApiClient reservationApiClient;
    @InjectMocks
    private ReservationApiService reservationApiService;

    @Test
    void shouldCallReservationApiClient() {
        // Arrange
        ReservationApiResponse reservationApiResponse = ReservationApiResponse.builder()
            .code("any")
            .errors(List.of("any1", "any2"))
            .build();

        when(reservationApiClient.get(anyString())).thenReturn(ResponseEntity.ok(reservationApiResponse));

        // Act
        ResponseEntity<ReservationApiResponse> reservationApiResponseResponseEntity = reservationApiService.doSomething();

        // Assert
        assertThat(reservationApiResponseResponseEntity).isEqualTo(ResponseEntity.ok(reservationApiResponse));
        verify(reservationApiClient).get("/get/any");
    }

}
