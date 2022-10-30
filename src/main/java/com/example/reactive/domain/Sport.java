package com.example.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("sport")
@NoArgsConstructor
@AllArgsConstructor
public class Sport {
    @Id
    private int id;
    private String name;
}
