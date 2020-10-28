package com.example.service.controller;

import com.example.service.model.Order;
import com.example.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Добавление заказа
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/api/v1/order")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order) {
        return orderService.createOrder(order);
    }
}