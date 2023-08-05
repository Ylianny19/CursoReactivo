package com.reactive.course.reactive.course.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    private Long id;
    private String nombre;
    private String codigo;
    private Integer stock;

}
