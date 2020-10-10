package com.example.service.service;

import com.example.service.repository.OrderRepository;
import com.example.service.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Проверка на валидность
 */
@Component
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public boolean createOrder(Orders order) {
        boolean result = false;
        if (order.getName() != null && order.getPrice() != null) {
            if (isNumeric(order.getPrice().toString())) {
                orderRepository.save(order);
                result = true;
            }
        }
        return result;
    }

    public boolean isNumeric(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
