package com.reactive.course.reactive.course.controller;

import com.reactive.course.reactive.course.model.Customer;
import com.reactive.course.reactive.course.model.Product;
import com.reactive.course.reactive.course.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductByIdSuccess(){
        var idProduct = 1L;
        when(productService.getProduct(idProduct)).thenReturn(Mono.just(buildProduct()));
        Mono<Product> result = productController.getProduct(idProduct);
        assertNotNull(result);
    }

    @Test
    public void testGetProductsSuccess() {
        when(productService.getAllProduct()).thenReturn((Flux.just(buildProduct())));
        Flux<Product> result = productController.getAllProduct();
        assertNotNull(result);
    }

    @Test
    public void testSaveProductsSuccess() {
        when(productService.saveProduct(buildProduct())).thenReturn(Mono.just(buildProduct()));
        Mono<Product> result = productController.saveProduct(buildProduct());
        assertNotNull(result);
    }

    @Test
    public void testDeleteProductsSuccess() {
        var idProduct = 1L;
        when(productService.deleteProduct(idProduct)).thenReturn(Mono.empty());
        Mono<Void> result = productController.deleteId(idProduct);
        assertEquals(Mono.empty(), result);
    }


    public Product buildProduct(){
        return Product.builder()
                .codigo("LI-01")
                .nombre("Linaza")
                .stock(52)
                .build();
    }

}
