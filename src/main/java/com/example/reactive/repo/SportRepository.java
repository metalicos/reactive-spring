package com.example.reactive.repo;


import com.example.reactive.domain.Sport;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SportRepository extends ReactiveCrudRepository<Sport, Integer> {
}
