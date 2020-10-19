package com.example.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customers {
    private String name;
    private String email_address;
}

