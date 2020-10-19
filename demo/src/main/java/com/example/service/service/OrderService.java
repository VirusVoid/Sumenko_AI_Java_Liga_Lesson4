package com.example.service.service;

import com.example.service.dao.OrderDAO;
import com.example.service.model.Customers;
import com.example.service.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Проверка на валидность заказа
 */
@Component
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public ResponseEntity<String> createOrderForCustomer(Orders order) {

        ArrayList<String> fields = new ArrayList<>();
        String responseBody = "";
        String currentCustomer = order.getCustomer_name();
        if (currentCustomer == null || order.getOrder_name() == null || order.getPrice() == null) {
            if (currentCustomer == null) {
                fields.add("customer_name");
            }
            if (order.getOrder_name() == null) {
                fields.add("order_name");
            }
            if (order.getPrice() == null) {
                fields.add("price");
            }
            for (String field : fields) {
                responseBody += "Ошибка в поле " + field + ": проверьте имя и значение поля (not null)\n";
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        } else {
            if (orderDAO.findCustomerByName(currentCustomer) == null) {
                Customers customer = Customers.builder().build();
                customer.setName(currentCustomer);
                orderDAO.createCustomer(customer);
            }
            orderDAO.saveOrder(order);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Идентификатор созданного заказа: " + order.getId());
    }
}