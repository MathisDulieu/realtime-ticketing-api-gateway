package com.mathisdulieu.ticketing.gateway.reservationapi;

import com.mathisdulieu.ticketing.library.api.reservation.ReservationApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(ReservationApiController.class)
class ReservationApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReservationApiService reservationApiService;

    @Test
    void shouldReturnReservationApiResponse() throws Exception {
        // Arrange
        ResponseEntity<ReservationApiResponse> reservationApiResponse = ResponseEntity.ok(
            ReservationApiResponse.builder()
                .code("anyCode")
                .errors(List.of("anyError1", "anyError2"))
                .build()
        );

        when(reservationApiService.doSomething()).thenReturn(reservationApiResponse);

        // Act
        ResultActions resultActions = mockMvc.perform(get("/api/v1/reservation/example"));

        // Assert
        String expectedReservationApiBodyResponse = """
            {
                "code": "anyCode",
                "errors": [
                    "anyError1",
                    "anyError2"
                ]
            }
            """;

        resultActions.andExpect(status().isOk());
        resultActions.andExpect(content().json(expectedReservationApiBodyResponse));
        verify(reservationApiService).doSomething();
    }

}
