package com.reactive.course.reactive.course.controller;



import com.reactive.course.reactive.course.model.Product;
import com.reactive.course.reactive.course.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping()
    public Flux<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteId(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @PostMapping()
    public Mono<Product> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
}
