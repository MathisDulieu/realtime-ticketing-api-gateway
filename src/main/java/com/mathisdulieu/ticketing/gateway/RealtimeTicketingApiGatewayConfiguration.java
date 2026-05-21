package com.mathisdulieu.ticketing.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RealtimeTicketingApiGatewayConfiguration {

    @Bean
    public RestClient restClient() {
        return RestClient.builder().build();
    }

}
