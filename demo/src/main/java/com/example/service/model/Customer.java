package com.example.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private int customer_id;
    private int order_id;
    private String name;
    private String email_address;
}

