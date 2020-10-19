package com.example.service.dao;

import com.example.service.model.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OrderDAOTest {

    @Autowired
    private OrderDAO orderDAO;

    @Test
    void testSaveOrder() {

        Orders order = Orders.builder()
                .customer_name("customer1")
                .order_name("testName")
                .price(75)
                .build();
        assertNotNull(order.getId());
        assertEquals(order.getOrder_name(), "testName");
        assertEquals(order.getCustomer_name(), "customer1");
        order.setPrice(5);
        assertEquals(order.getPrice(), 5);
    }
}