package com.example.service.repository;

import com.example.service.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Отправка запроса к базе данных
 */
@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Orders save(Orders order) {
        String sqlQuery = "insert into orders(order_id, name, price) " +
                "values (?, ?, ?)";
        jdbcTemplate.update(sqlQuery, order.getOrderId(), order.getName(), order.getPrice());
        return order;
    }

    public List<Orders> findAll() {
        return jdbcTemplate.query("select * from orders", this::mapRowToOrders);
    }

    // This method is an implementation of the functional interface RowMapper.
    // It is used to map each row of a ResultSet to an object.
    private Orders mapRowToOrders(ResultSet resultSet, int rowNum) throws SQLException {
        return Orders.builder()
                .orderId(resultSet.getInt("order_id"))
                .name(resultSet.getString("name"))
                .price(resultSet.getInt("price"))
                .build();
    }


  /*  public void insertOrder(Orders order) {
        String sql = "INSERT INTO ORDERS (ORDER_ID, NAME, PRICE) VALUES (?,?,?)";
        //order.setOrderId(0);
        jdbcTemplate.update(sql,
                order.getOrderId(),
                order.getName(),
                order.getPrice());
        //order.setOrderId(holder.getKey().intValue());
    }

    public List<Orders> getAllOrders() {
        String sql = "SELECT * FROM ORDERS";
        List<Orders> orders = jdbcTemplate.query(sql, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Orders(rs.getInt(1),
                        rs.getString(2), rs.getInt(3));
            }
        });
        return orders;
    }*/
}
