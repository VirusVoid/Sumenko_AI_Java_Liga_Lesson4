package com.example.service.service;

import com.example.service.dao.OrderDAO;
import com.example.service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Проверка заказа на валидность
 */
@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    /**
     * Создает новый заказ
     * @param order заказ
     * @return Http-статус=OK и id созданного заказа
     */
    public ResponseEntity createOrder(Order order) {
        orderDAO.createOrder(order);
        return new ResponseEntity<>(order.getId(), HttpStatus.OK);
    }
}