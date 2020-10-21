package com.example.service.controller;

import com.example.service.dao.OrderDAO;
import com.example.service.model.Orders;
import com.example.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Добавление заказа
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/api/v1/order")
    public ResponseEntity<?> createOrder(@RequestBody Orders order) {
        return orderService.createOrderForCustomer(order);
    }
}

@ControllerAdvice
class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>("Некорректный JSON запрос (статус: "+status+") \n"+ ex.toString(), HttpStatus.BAD_REQUEST);
    }
}