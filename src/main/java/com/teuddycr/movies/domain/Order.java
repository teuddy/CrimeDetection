package com.teuddycr.movies.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Order {
    private String id;
    private String customerId;
    private BigDecimal total;
}
