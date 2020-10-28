package com.example.service.service;

import com.example.service.dao.OrderDAO;
import com.example.service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Проверка на валидность заказа
 */
@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public ResponseEntity createOrder(Order order) {
        orderDAO.createOrder(order);
        return new ResponseEntity<>(order.getId(), HttpStatus.OK);
    }
}