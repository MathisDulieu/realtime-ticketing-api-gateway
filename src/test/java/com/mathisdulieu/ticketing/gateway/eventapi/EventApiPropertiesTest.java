package com.mathisdulieu.ticketing.gateway.eventapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EventApiPropertiesTest {

    @Test
    void shouldNotThrow_whenPropertiesAreComplete() {
        // Arrange
        EventApiProperties eventApiProperties = new EventApiProperties("baseUrl");

        // Act
        eventApiProperties.afterPropertiesSet();

        // Assert
        assertThat(eventApiProperties.baseUrl()).isEqualTo("baseUrl");
    }

    @ParameterizedTest
    @MethodSource("getCasesWithIncompleteProperties")
    void shouldThrow_whenPropertiesAreIncomplete(String baseUrl, String errorMessage) {
        // Arrange
        EventApiProperties eventApiProperties = new EventApiProperties(baseUrl);

        // Act & Assert
        assertThatThrownBy(eventApiProperties::afterPropertiesSet)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(errorMessage);
    }

    private static Stream<Arguments> getCasesWithIncompleteProperties() {
        return Stream.of(
            Arguments.of(null, "event-api.baseUrl must be given"),
            Arguments.of(" ", "event-api.baseUrl must be given")
        );
    }

}
