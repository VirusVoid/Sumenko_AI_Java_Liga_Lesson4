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
        Orders order = Orders.builder().build();
        order.setCustomer_name("customerFirst");
        order.setOrder_name("orderFirst");
        order.setPrice(50);

        Orders otherOrder = Orders.builder()
                .customer_name("q")
                .order_name("e")
                .price(89)
                .build();
       /* ResponseEntity result = new ResponseEntity(HttpStatus.OK);
        ResponseEntity result1 = orderService.createOrderForCustomer(otherOrder);*/
        System.out.println(orderService.createOrderForCustomer(order));
        //assertNotNull(result);
       /* assertEquals(result, result1);
        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(result.getBody(), order.getId());*/
    }
}