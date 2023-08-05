package com.reactive.course.reactive.course.controller;

import com.reactive.course.reactive.course.model.Sale;
import com.reactive.course.reactive.course.service.SaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SaleControllerTest {

    @Mock
    private SaleService saleService;

    @InjectMocks
    private SaleController saleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetSaleByIdSuccess(){
        var idCategory = 1L;
        when(saleService.getSale(idCategory)).thenReturn(Mono.just(buildSale()));
        Mono<Sale> result = saleController.getSale(idCategory);
        assertNotNull(result);
    }
    @Test
    public void testGetSaleSuccess() {
        when(saleService.getAllSale()).thenReturn((Flux.just(buildSale())));
        Flux<Sale> result = saleController.getAllSale();
        assertNotNull(result);
    }
    public Sale buildSale(){
        return Sale.builder()
                .id(1L)
                .nombre("Venta carora")
                .fechaGeneracion(LocalDateTime.now())
                .total(122.32)
                .build();
    }
}
