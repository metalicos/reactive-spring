package com.example.reactive.client;

import com.example.reactive.domain.Sport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SportClient {
    public static final String SPORTS = "/sports";
    private final WebClient webClient;

    public Flux<Sport> getSport() {
        return webClient.get()
                .uri(SPORTS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<HashMap<String, Object>>() {
                })
                .flatMap(resp -> Flux.fromIterable(fetchSportList((ArrayList<HashMap<String, Object>>) resp.get("data"))));
    }

    private List<Sport> fetchSportList(ArrayList<HashMap<String, Object>> sportDataList) {
        return sportDataList.stream()
                .map(data -> {
                    if (data.get("id") == null || data.get("attributes") == null) {
                        return new Sport();
                    }
                    var id = (Integer) data.get("id");
                    var name = (String) ((HashMap<String, Object>) data.get("attributes")).get("name");
                    return new Sport(id, name);
                }).collect(Collectors.toList());
    }
}
