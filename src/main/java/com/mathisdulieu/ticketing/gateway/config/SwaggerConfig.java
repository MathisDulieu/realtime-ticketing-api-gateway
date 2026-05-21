package com.mathisdulieu.ticketing.gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Realtime Ticketing — API Gateway")
                .description("Central entry point routing HTTP requests to internal microservices")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Mathis Dulieu")
                    .url("https://github.com/MathisDulieu")))
            .servers(List.of(
                new Server().url("http://localhost:8080").description("Local"),
                new Server().url("https://api.yourdomain.com").description("Production")
            ));
    }

}
