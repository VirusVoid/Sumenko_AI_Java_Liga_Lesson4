package com.example.service.controller;

import com.example.service.model.Orders;
import com.example.service.dao.OrderDAO;
import com.example.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Добавление заказа
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/api/v1/order")
    public ResponseEntity<String> createOrder(@RequestBody Orders order) {
        return orderService.createOrderForCustomer(order);
    }
}