package com.example.service.dao;

import com.example.service.model.Customers;
import com.example.service.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Отправка запроса к базе данных
 */
@Repository
public class OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Orders saveOrder(Orders order) {
        String insertOrder = "insert into orders(customer_name, order_name, price) " +
                "values (?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String orderId = "id";
        jdbcTemplate.update(con -> {
            PreparedStatement pst = con.prepareStatement(insertOrder,
                    new String[]{orderId});
            pst.setString(1, order.getCustomer_name());
            pst.setString(2, order.getOrder_name());
            pst.setInt(3, order.getPrice());
            return pst;
        }, keyHolder);
        Number key = keyHolder.getKey();
        order.setId(key.longValue());
        return order;
    }

    public Customers createCustomer(Customers customer) {
        String createCustomer = "insert into customers(name, email_address)" +
                " values (?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String customerId = "id";
        String emailAddress = customer.getName() + "@mail.ru";
        jdbcTemplate.update(con -> {
            PreparedStatement pst = con.prepareStatement(createCustomer);
            pst.setString(1, customer.getName());
            pst.setString(2, emailAddress);
            return pst;
        });
        return customer;
    }

    public Customers findCustomerByName(String name) {
        String sql = "select * from customers where name = ?";
        try {
            return (Customers) this.jdbcTemplate.queryForObject(
                    sql, new Object[]{name}, this::mapRowToCustomers);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private Customers mapRowToCustomers(ResultSet resultSet, int rowNum) throws SQLException {
        return Customers.builder()
                .name(resultSet.getString("name"))
                .email_address(resultSet.getString("email_address"))
                .build();
    }
}
