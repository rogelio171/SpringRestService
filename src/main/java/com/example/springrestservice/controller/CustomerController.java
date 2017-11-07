package com.example.springrestservice.controller;

import com.example.springrestservice.model.Customer;
import com.example.springrestservice.repository.CustomerRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Create
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    //Read
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
       return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        return customerRepository.findOne(id);
    }

    //Update
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    //Delete
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerRepository.delete(id);
    }
}
