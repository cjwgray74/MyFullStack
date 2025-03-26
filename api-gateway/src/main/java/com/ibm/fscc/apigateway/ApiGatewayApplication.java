package com.ibm.fscc.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator apiRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/api/auth/**")
						.filters(f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://LOGIN-WS"))
				.route(p -> p
						.path("/api/employee/**")
						.filters(f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://EMPLOYEE-WS"))
				.route(p -> p
						.path("/api/user/**")
						.filters(f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://KAFKA-WS"))
				.build();


	}
}