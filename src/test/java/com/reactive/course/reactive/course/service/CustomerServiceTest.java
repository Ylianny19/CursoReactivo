package com.reactive.course.reactive.course.service;

import com.reactive.course.reactive.course.adapter.CustomerAdapter;
import com.reactive.course.reactive.course.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerAdapter customerAdapter;

    @Test
    public void testGetCustomerByIdSuccess(){
        var idCustomer = 1L;
        when(customerAdapter.getCustomer(idCustomer)).thenReturn(Mono.just(buildCustomer()));
        Mono<Customer> result = customerService.getCustomer(idCustomer);
        assertNotNull(result);
    }

    @Test
    public void testGetCustomersSuccess() {
        when(customerAdapter.getAllCustomer()).thenReturn((Flux.just(buildCustomer())));
        Flux<Customer> result = customerService.getAllCustomer();
        assertNotNull(result);
    }
    @Test
    public void testSaveCustomersSuccess() {
        when(customerAdapter.saveCustomer(buildCustomer())).thenReturn(Mono.just(buildCustomer()));
        Mono<Customer> result = customerService.saveCustomer(buildCustomer());
        assertNotNull(result);
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
