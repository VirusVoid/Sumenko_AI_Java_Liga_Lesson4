package com.example.service.service;

import com.example.service.dao.OrderDAO;
import com.example.service.model.Customer;
import com.example.service.model.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Тестрование уровня Service
 */
@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @MockBean
    private OrderDAO orderDAO;

    @Test
    void testCreateOrder() {

        Order order = Order.builder()
                .customer_id(1)
                .name("orderFirst")
                .price(50)
                .build();
        ResponseEntity result = orderService.createOrder(order);
        Mockito.verify(orderDAO, Mockito.times(1)).createOrder(order);
        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(result.getBody(), order.getId());
        assertNotNull(order.getCustomer_id());
        assertNotNull(order.getName());
        assertNotNull(order.getPrice());
    }
}