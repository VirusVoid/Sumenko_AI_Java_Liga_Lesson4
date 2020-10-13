package com.example.service.controller;

import com.example.service.model.Orders;
import com.example.service.repository.OrderRepository;
import com.example.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Добавление заказа
 */
@RestController
//@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    OrderRepository orderRepository;

    @GetMapping(value ="/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") Integer id){
        Orders order = orderRepository.findById(id);
        if (order==null){
            return new ResponseEntity<String>("No user found with"+id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Orders>(order, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/order")
    public ResponseEntity<?> createOrder(@RequestBody Orders order) {
        return orderService.createOrder(order);
        //return ResponseEntity.ok().body(order.getOrderId());
    }
}