package com.example.service.controller;

import com.example.service.model.Orders;
import com.example.service.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Добавление заказа
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {
   @Autowired
   private OrderService orderService;

    @PostMapping(value = "/order")
    ResponseEntity createOrder(@RequestBody Orders order){
        orderService.createOrder(order);
        return ResponseEntity.ok().body(order.getOrderId());
    }
}
