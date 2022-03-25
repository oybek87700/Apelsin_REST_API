package com.example.apelsin_restapi.controller;
import com.example.apelsin_restapi.dto.ApiResponse;
import com.example.apelsin_restapi.entity.Customer;
import com.example.apelsin_restapi.entity.Order;
import com.example.apelsin_restapi.repository.CustomerRepository;
import com.example.apelsin_restapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    final CustomerRepository customerRepository;
    final CustomerService customerService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Customer> all = customerRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        return ResponseEntity.status(byId.isEmpty() ?
                HttpStatus.NOT_FOUND : HttpStatus.OK).body(byId.orElse(new Customer()));
    }
    @PostMapping
    public HttpEntity<?> add(@RequestBody Customer customer) {
        ApiResponse response = customerService.add(customer);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody Customer customer) {
        ApiResponse response = customerService.edit(id, customer);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isEmpty()) return ResponseEntity.status(404).body("NOT FOUND");
        Customer customer = byId.get();
        customer.setActive(false);
        customerRepository.save(customer);
        return ResponseEntity.ok().body("DELETED!");
    }

    @GetMapping("/customers_without_orders")
    public HttpEntity<?> getCustomers_without_orders() {
        List<Customer> all = customerRepository.customers_without_orders();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/customers_last_orders")
    public HttpEntity<?> getCustomers_last_orders() {
        List<Customer> all = customerRepository.customers_last_orders();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/number_of_products_in_year")
    public HttpEntity<?> getNumber_of_products_in_year() {
        List<Customer> all = customerRepository.number_of_products_in_year();
        return ResponseEntity.ok().body(all);
    }
}
