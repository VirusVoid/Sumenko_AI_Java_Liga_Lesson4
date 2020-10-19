package com.example.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {

    private long id;
    private String customer_name;
    private String order_name;
    private Integer price;
}
