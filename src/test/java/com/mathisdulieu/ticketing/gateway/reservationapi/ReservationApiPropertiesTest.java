package com.mathisdulieu.ticketing.gateway.reservationapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReservationApiPropertiesTest {

    @Test
    void shouldNotThrow_whenPropertiesAreComplete() {
        // Arrange
        ReservationApiProperties reservationApiProperties = new ReservationApiProperties("baseUrl");

        // Act
        reservationApiProperties.afterPropertiesSet();

        // Assert
        assertThat(reservationApiProperties.baseUrl()).isEqualTo("baseUrl");
    }

    @ParameterizedTest
    @MethodSource("getCasesWithIncompleteProperties")
    void shouldThrow_whenPropertiesAreIncomplete(String baseUrl, String errorMessage) {
        // Arrange
        ReservationApiProperties reservationApiProperties = new ReservationApiProperties(baseUrl);

        // Act & Assert
        assertThatThrownBy(reservationApiProperties::afterPropertiesSet)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(errorMessage);
    }

    private static Stream<Arguments> getCasesWithIncompleteProperties() {
        return Stream.of(
            Arguments.of(null, "reservation-api.baseUrl must be given"),
            Arguments.of(" ", "reservation-api.baseUrl must be given")
        );
    }

}
