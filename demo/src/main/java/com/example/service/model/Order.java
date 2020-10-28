package com.example.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Order {
    /**
     * Идентификатор заказа
     */
    @Id
    private Integer id;
    /**
     * Идентификатор покупателя
     */
    @NotNull
    private Integer customer_id;
    /**
     * Название заказа
     */
    @NotNull
    private String name;
    /**
     * Стоимость заказа
     */
    @NotNull
    private Integer price;
}
