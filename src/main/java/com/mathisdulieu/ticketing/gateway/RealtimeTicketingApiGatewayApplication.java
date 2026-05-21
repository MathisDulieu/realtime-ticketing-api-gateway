package com.mathisdulieu.ticketing.gateway;

import com.mathisdulieu.ticketing.gateway.config.CorsProperties;
import com.mathisdulieu.ticketing.gateway.eventapi.EventApiProperties;
import com.mathisdulieu.ticketing.gateway.inventoryapi.InventoryApiProperties;
import com.mathisdulieu.ticketing.gateway.reservationapi.ReservationApiProperties;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.mathisdulieu.ticketing.gateway"})
@EnableConfigurationProperties({
    CorsProperties.class,
    EventApiProperties.class,
    InventoryApiProperties.class,
    ReservationApiProperties.class
})
public class RealtimeTicketingApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimeTicketingApiGatewayApplication.class, args);
	}

    @PostConstruct
    void steUtcTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        log.info("RealtimeTicketingApiGatewayApplication running in UTC timezone at : {}", new Date());
    }

    @Configuration
    @Profile("test")
    @ComponentScan(lazyInit = true)
    static class ConfigForShorterBootTimeForTests {
    }
}
