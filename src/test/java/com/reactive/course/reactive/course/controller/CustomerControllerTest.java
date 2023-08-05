package com.reactive.course.reactive.course.controller;
import com.reactive.course.reactive.course.model.Customer;
import com.reactive.course.reactive.course.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCustomerByIdSuccess(){
        var idCustomer = 1L;
        when(customerService.getCustomer(idCustomer)).thenReturn(Mono.just(buildCustomer()));
        Mono<Customer> result = customerController.getCustomer(idCustomer);
        assertNotNull(result);
    }

    @Test
    public void testGetCustomersSuccess() {
        when(customerService.getAllCustomer()).thenReturn((Flux.just(buildCustomer())));
        Flux<Customer> result = customerController.getAllCustomer();
        assertNotNull(result);
    }
    @Test
    public void testSaveCustomersSuccess() {
        when(customerService.saveCustomer(buildCustomer())).thenReturn(Mono.just(buildCustomer()));
        Mono<Customer> result = customerController.saveCustomer(buildCustomer());
        assertNotNull(result);
    }

    @Test
    public void testDeleteCustomersSuccess() {
        var idCustomer = 1L;
        when(customerService.deleteId(idCustomer)).thenReturn(Mono.empty());
        Mono<Void> result = customerController.deleteCustomer(idCustomer);
        assertEquals(Mono.empty(), result);
    }
    public Customer buildCustomer(){
        return Customer.builder()
                .id(1L)
                .nombre("Martina")
                .apellido("Lopez")
                .telefono("32547956")
                .direccion("Av 3 Los linares")
                .build();
    }
}
