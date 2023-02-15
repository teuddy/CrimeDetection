package com.teuddycr.movies.infra.inputport;

import java.math.BigDecimal;

import com.teuddycr.movies.domain.Order;

public interface OrderInputPort {

    public Order createOrder(String customerId, BigDecimal total);
}
