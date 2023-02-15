package com.teuddycr.movies.application;

import java.util.List;

import com.teuddycr.movies.domain.Customer;
import com.teuddycr.movies.infra.inputport.CustomerInputPort;

public class CustomerUseCase implements CustomerInputPort {

    @Override
    public Customer createCustomer(String name, String country) {
        return null;
    }

    @Override
    public Customer getById(String customerId) {

        return null;
    }

    @Override
    public List<Customer> getAll() {

        return null;
    }

}
