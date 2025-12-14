package com.banking.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

    @Bean
    public RouteLocator routeConfig(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("accounts_route", p -> p
                        .path("/accounts/**")
                        .filters(f -> f
                                .rewritePath("/accounts/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(c -> c
                                        .setName("accountsCircuitBreaker")
                                        .setFallbackUri("forward:/accountsFallback"))
                        )
                        .uri("lb://accounts-service")
                )

                .route("cards_route", p -> p
                        .path("/cards/**")
                        .filters(f -> f
                                .rewritePath("/cards/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(c -> c
                                        .setName("cardsCircuitBreaker")
                                        .setFallbackUri("forward:/cardsFallback"))
                        )
                        .uri("lb://cards-service")
                )

                .route("loans_route", p -> p
                        .path("/loans/**")
                        .filters(f -> f
                                .rewritePath("/loans/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(c -> c
                                        .setName("loansCircuitBreaker")
                                        .setFallbackUri("forward:/loansFallback"))
                        )
                        .uri("lb://loans-service")
                ).build();

	}


}
