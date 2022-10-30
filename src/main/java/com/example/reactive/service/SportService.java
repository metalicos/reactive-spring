package com.example.reactive.service;

import com.example.reactive.client.SportClient;
import com.example.reactive.domain.Sport;
import com.example.reactive.repo.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SportService {
    private final SportRepository sportRepository;
    private final SportClient sportClient;

    public Flux<Sport> list() {
        return sportRepository.findAll();
    }

    public Mono<Sport> one(Integer id) {
        return sportRepository.findById(id);
    }

    public Mono<Sport> add(Sport sport) {
        return sportRepository.saveSport(sport.getId(), sport.getName());
    }

    public Flux<Sport> fill() {
        return sportClient.getSport()
                .flatMap(sport -> sportRepository.saveSport(sport.getId(), sport.getName()));
    }
}
