package com.example.reactive.router;

import com.example.reactive.handler.SportHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SportRouter {

    @Bean
    public RouterFunction<ServerResponse> route(SportHandler sportHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/fill"), sportHandler::fill);
    }
}
