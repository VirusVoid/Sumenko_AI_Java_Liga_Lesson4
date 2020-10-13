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

    public ResponseEntity<?> createOrder(Orders order) {
       /* boolean result = false;
        if (order.getName() != null && order.getPrice() != null) {
            if (isNumeric(order.getPrice().toString())) {
                orderRepository.saveOrder(order);
                result = true;
            }
        }*/

        if (orderRepository.findById(order.getOrderId())!=null){
            return new ResponseEntity<String>("Dublicate Entry: "+ order.getOrderId(), HttpStatus.IM_USED);
        }
        else return ResponseEntity.status(HttpStatus.OK).body(order.getOrderId());
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
