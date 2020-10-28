package com.example.service.dao;

import com.example.service.config.WebConfiguration;
import com.example.service.model.Customer;
import com.example.service.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

/**
 * Отправка запроса к базе данных
 */
@Repository
@RequiredArgsConstructor
public class OrderDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    private final String SQL_INSERT_ORDER = "insert into `order`(customer_id, name, price) " +
            "values (?, ?, ?)";

    public Order createOrder(Order order) {
        String orderId = "id";
        int numOfRows = jdbcTemplate.update(con -> {
            PreparedStatement pst = con.prepareStatement(SQL_INSERT_ORDER,
                    new String[]{orderId});
            pst.setInt(1, order.getCustomer_id());
            pst.setString(2, order.getName());
            pst.setInt(3, order.getPrice());
            return pst;
        }, keyHolder);
        if (numOfRows > 0) {
            if (keyHolder.getKey() != null) {
                order.setId(keyHolder.getKey().intValue());
            }
        }
//        order.setId(keyHolder.getKey().intValue());
        return order;
    }


    public Customer findCustomerById(Integer id) {
        String sql = "select * from customer where id = ?";
        try {
            return (Customer) this.jdbcTemplate.queryForObject(
                    sql, new Object[]{id}, new BeanPropertyRowMapper(Customer.class));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Customer createCustomer(Customer customer) {
        String createCustomer = "insert into customer(id, name, email_address)" +
                " values (?, ?, ?)";
        String name = "example";
        String emailAddress = name + "@mail.ru";
        jdbcTemplate.update(con -> {
            PreparedStatement pst = con.prepareStatement(createCustomer);
            pst.setInt(1, customer.getId());
            pst.setString(2, name);
            pst.setString(3, emailAddress);
            return pst;
        });
        return customer;
    }
}
