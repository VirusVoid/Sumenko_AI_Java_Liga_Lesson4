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
 * Обработка HTTP-запроса по созданию заказа
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Создает POST-запрос для создания заказа на сервере
     * @param order заказ
     * @return id созданного заказа и ответ сервера со статусом обработки запроса
     */
    @PostMapping(value = "/api/v1/order")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order) {
        return orderService.createOrder(order);
    }
}