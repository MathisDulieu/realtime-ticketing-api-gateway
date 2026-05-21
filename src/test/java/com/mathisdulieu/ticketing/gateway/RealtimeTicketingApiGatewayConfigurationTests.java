package com.mathisdulieu.ticketing.gateway;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class RealtimeTicketingApiGatewayConfigurationTests {

    @Bean
    public MBeanExporter exporter() {
        return mock(MBeanExporter.class);
    }

}
