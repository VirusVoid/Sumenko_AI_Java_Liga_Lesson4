package com.example.service.service;

import com.example.service.model.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    void createOrder() {
        Orders order = Orders.builder()
                .name("serviceExample")
                .price(56)
                .build();
        boolean result = orderService.createOrder(order);
        assertNotNull(result);
        assertEquals(result, true);

        int a = 87;
        String s = "qwe";
        assertEquals(orderService.isNumeric(String.valueOf(a)), true);
        assertEquals(orderService.isNumeric(s),false);
    }
}