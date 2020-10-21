package com.example.service.service;

import com.example.service.dao.OrderDAO;
import com.example.service.model.Customers;
import com.example.service.model.Orders;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @MockBean
    private OrderDAO orderDAO;

    @Test
    void testCreateOrderForCustomer() {

        Orders order = Orders.builder().build();
        order.setCustomer_name("customerFirst");
        order.setOrder_name("orderFirst");
        order.setPrice(50);

        ResponseEntity result = orderService.createOrderForCustomer(order);
        Mockito.verify(orderDAO, Mockito.times(1)).saveOrder(order);
        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(result.getBody(), "Идентификатор созданного заказа: " + order.getId());
        assertNotNull(order.getCustomer_name());
        assertNotNull(order.getOrder_name());
        assertNotNull(order.getPrice());
    }

    @Test
    void testCreateCustomer() {
        Customers customer = Customers.builder()
                .name("John")
                .email_address("John@mail.ru")
                .build();

        Mockito.doReturn(Customers.builder()
                .name("John")
                .email_address("John@mail.ru")
                .build())
                .when(orderDAO)
                .findCustomerByName("John");
        assertNull(orderDAO.createCustomer(customer));
    }
}