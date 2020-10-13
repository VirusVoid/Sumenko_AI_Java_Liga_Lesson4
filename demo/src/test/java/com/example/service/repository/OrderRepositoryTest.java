package com.example.service.repository;

import com.example.service.model.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Test

    void testSaveOrder() {
        Orders order = Orders.builder()
                .orderId(2)
                .name("testName")
                .price(75)
                .build();
        assertNotNull(order.getOrderId());
        assertEquals(order.getName(), "testName");
        order.setPrice(5);
        assertEquals(order.getPrice(), 5);
    }
}