package com.mathisdulieu.ticketing.gateway.inventoryapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InventoryApiPropertiesTest {

    @Test
    void shouldNotThrow_whenPropertiesAreComplete() {
        // Arrange
        InventoryApiProperties inventoryApiProperties = new InventoryApiProperties("baseUrl");

        // Act
        inventoryApiProperties.afterPropertiesSet();

        // Assert
        assertThat(inventoryApiProperties.baseUrl()).isEqualTo("baseUrl");
    }

    @ParameterizedTest
    @MethodSource("getCasesWithIncompleteProperties")
    void shouldThrow_whenPropertiesAreIncomplete(String baseUrl, String errorMessage) {
        // Arrange
        InventoryApiProperties inventoryApiProperties = new InventoryApiProperties(baseUrl);

        // Act & Assert
        assertThatThrownBy(inventoryApiProperties::afterPropertiesSet)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(errorMessage);
    }

    private static Stream<Arguments> getCasesWithIncompleteProperties() {
        return Stream.of(
            Arguments.of(null, "inventory-api.baseUrl must be given"),
            Arguments.of(" ", "inventory-api.baseUrl must be given")
        );
    }

}
