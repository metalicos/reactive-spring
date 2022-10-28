package com.example.reactive.handler;

import com.example.reactive.domain.Sport;
import com.example.reactive.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SportHandler {

    private final SportService sportService;

    public Mono<ServerResponse> fill(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sportService.fill(), Sport.class);
    }
}
