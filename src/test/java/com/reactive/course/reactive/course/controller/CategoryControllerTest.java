package com.reactive.course.reactive.course.controller;


import com.reactive.course.reactive.course.model.Category;
import com.reactive.course.reactive.course.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {


    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCategoryByIdSuccess(){
        var idCategory = 1L;
        when(categoryService.getCategory(idCategory)).thenReturn(Mono.just(buildCategory()));
        Mono<Category> result = categoryController.getCategory(idCategory);
        assertNotNull(result);
    }
    @Test
    public void testGetCategorySuccess() {
        when(categoryService.getAllCategory()).thenReturn((Flux.just(buildCategory())));
        Flux<Category> result = categoryController.getAllCategory();
        assertNotNull(result);
    }
    public Category buildCategory(){
        return Category.builder()
                .id(1L)
                .codigo("LEDES-12")
                .descripcion("Leches Deslactosadas")
                .nombre("Leche")
                .build();
    }
}
