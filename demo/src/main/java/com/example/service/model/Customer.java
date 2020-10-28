package com.example.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Customer {
    /**
     * Идентификатор покупателя
     */
    @Id
    private Integer id;
    /**
     * Имя покупателя
     */
    @NotNull
    private String name;
    /**
     * E-mail полупателя
     */
    @NotNull
    private String email_address;
}

