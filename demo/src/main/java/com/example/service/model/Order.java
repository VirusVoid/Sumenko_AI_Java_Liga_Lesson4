package com.example.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Order {
    @Id
    private Integer id;

    @NotNull
    private Integer customer_id;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

}
