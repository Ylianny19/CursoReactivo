package com.reactive.course.reactive.course.model;


import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Builder
@Data
public class Sale {

    @Id
    private Long id;

    private String nombre;

    private LocalDateTime fechaGeneracion;

    private Double total;
}
