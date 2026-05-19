package com.mathisdulieu.ticketing.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(RealtimeTicketingApiGatewayConfigurationTests.class)
class RealtimeTicketingApiGatewayApplicationTests {

	@Test
	void contextLoads() {}

}