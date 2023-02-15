package com.teuddycr.movies.infra.inputport;

import java.util.List;

import com.teuddycr.movies.domain.Customer;

public interface CustomerInputPort {
    // here we create the methods htat should me needed (implemented) for our
    // customers "endpoints"
    public Customer createCustomer(String name, String country);

    public Customer getById(String customerId);

    public List<Customer> getAll();
}
