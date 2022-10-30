package com.example.reactive.repo;


import com.example.reactive.domain.Sport;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface SportRepository extends ReactiveCrudRepository<Sport, Integer> {

    @Modifying
    @Query("INSERT INTO public.sport VALUES (:id, :name)")
    Mono<Sport> saveSport(@Param("id") Integer id,
                          @Param("name") String name);
}
