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
//update
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator ApiRouteConfig(RouteLocatorBuilder routeLocatorBuilder){

		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/API/login/**")
						.filters(f -> f.rewritePath("/API/login/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						//.uri("lb://LOGIN-WS"))
				      	.uri("http://localhost:8083"))
				.route(p -> p
						.path("/API/employee/**")
						.filters(f -> f.rewritePath("/API/employee/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						//.uri("lb://EMPLOYEE-WS"))
						.uri("http://localhost:8082"))
				.build();
	}
}
