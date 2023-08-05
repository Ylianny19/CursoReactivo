package com.reactive.course.reactive.course.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;

    private String direccion;

}
