package com.example.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Customer {
    @Id
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String email_address;
}

