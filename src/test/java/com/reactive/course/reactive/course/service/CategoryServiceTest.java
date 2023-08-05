package com.reactive.course.reactive.course.service;

import com.reactive.course.reactive.course.adapter.CategoryAdapter;
import com.reactive.course.reactive.course.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryAdapter categoryAdapter;

    @Test
    public void testGetByIdSuccess(){
        var idCategory = 1L;
        when(categoryAdapter.getCategory(idCategory)).thenReturn(Mono.just(buildCategory()));
        Mono<Category> result = categoryService.getCategory(idCategory);
        assertNotNull(result);
    }
    @Test
    public void testGetSuccess() {
        when(categoryAdapter.getAllCategory()).thenReturn((Flux.just(buildCategory())));
        Flux<Category> result = categoryService.getAllCategory();
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
