package com.teuddycr.movies.application;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teuddycr.movies.domain.Customer;
import com.teuddycr.movies.infra.inputport.CustomerInputPort;
import com.teuddycr.movies.infra.outputport.EntityRepository;

@Component
public class CustomerUseCase implements CustomerInputPort {
    @Autowired
    EntityRepository entityRepository;

    @Override
    public Customer createCustomer(String name, String country) {
        Customer customer = Customer.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .country(country)
                .build();

        return entityRepository.save(customer);
    }

    @Override
    public Customer getById(String customerId) {
        return entityRepository.getById(customerId, Customer.class);
    }

    @Override
    public List<Customer> getAll() {
        return entityRepository.getAll(Customer.class);
    }

}
