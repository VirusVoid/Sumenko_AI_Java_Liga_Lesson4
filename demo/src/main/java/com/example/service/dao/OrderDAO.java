package com.example.service.dao;

import com.example.service.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

/**
 * Отправление запроса в базу данных
 */
@Repository
@RequiredArgsConstructor
public class OrderDAO {
    /**
     * Объект для выполнения запросов в базу данных
     */
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    /**
     * Генератор уникальных ключей
     */
    private final KeyHolder keyHolder = new GeneratedKeyHolder();
    /**
     * SQL-запрос на добавление заказа
     */
    private final String SQL_INSERT_ORDER = "insert into `order`(customer_id, name, price) " +
            "values (?, ?, ?)";

    /**
     * Добавляет заказ в базу данных и назначает id заказа
     * @param order заказ
     * @return заказ с назначенным id
     */
    public Order createOrder(Order order) {
        String orderId = "id";
        int numOfChangedRows = jdbcTemplate.update(con -> {
            PreparedStatement pst = con.prepareStatement(SQL_INSERT_ORDER,
                    new String[]{orderId});
            pst.setInt(1, order.getCustomer_id());
            pst.setString(2, order.getName());
            pst.setInt(3, order.getPrice());
            return pst;
        }, keyHolder);
        if (numOfChangedRows > 0) {
            if (keyHolder.getKey() != null) {
                order.setId(keyHolder.getKey().intValue());
            }
        }
        return order;
    }
}
