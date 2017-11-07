package com.example.springrestservice;

import com.example.springrestservice.model.Customer;
import com.example.springrestservice.repository.CustomerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestServiceApplication.class, args);
    }
}

@Component
class SampleData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    SampleData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Stream.of("Alejandra", "Valeria", "Brenda", "Francisco", "Kelly", "Roberto", "Luis", "Daniela")
                .forEach(name -> customerRepository.save(new Customer(name)));

        customerRepository.findAll().forEach(System.out::println);

    }
}
