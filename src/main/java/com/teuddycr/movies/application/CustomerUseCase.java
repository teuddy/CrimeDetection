package com.teuddycr.movies.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teuddycr.movies.domain.CacheData;
import com.teuddycr.movies.domain.Customer;
import com.teuddycr.movies.infra.inputport.CustomerInputPort;
import com.teuddycr.movies.infra.outputport.CacheOutputPort;
import com.teuddycr.movies.infra.outputport.DatabaseOutputPort;

@Component
public class CustomerUseCase implements CustomerInputPort {
    @Autowired
    DatabaseOutputPort databaseOutputPort;
    // the interface -> gets implemented in another place
    // cache interface - > gets implemented by cache storage implementation -> redis
    @Autowired
    CacheOutputPort cacheOutputPort;

    @Override
    public Customer createCustomer(String name, String country) {
        // save on the databse
        Customer customer = Customer.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .country(country)
                .build();
        // save on redis
        cacheOutputPort.save(new CacheData(customer.getId(), customer.getCountry()));
        // then return whats on redis
        return databaseOutputPort.save(customer);
    }

    @Override
    public Customer getById(String customerId) {
        // search on redis
        CacheData cacheData = cacheOutputPort.get(customerId);

        if (cacheData != null) {
            return Customer.builder()
                    .id(cacheData.getKey())
                    .name("an invented name just for show up")
                    .country(cacheData.getValue())
                    .build();
        } else {
            return databaseOutputPort.getById(customerId, Customer.class);

        }
        // its if diff than null then return that customer
        // if (cacheData != null) {
        // return Customer.builder()
        // .id(cacheData.getKey())
        // .name("an invented name")
        // .country(cacheData.getValue())
        // .build();
        // } else {
        // // or search for it in the db
        // return databaseOutputPort.getById(customerId, Customer.class);

    }

    @Override
    public List<Customer> getAll() {
        return databaseOutputPort.getAll(Customer.class);
    }

}
