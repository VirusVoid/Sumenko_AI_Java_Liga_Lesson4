package com.example.service.repository;

import com.example.service.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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

    public Boolean saveOrder(Orders order) {
        String insertOrder = "insert into orders(order_id, name, price) " +
                "values (?, ?, ?)";
        return jdbcTemplate.execute(insertOrder, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1, order.getOrderId());
                ps.setString(2, order.getName());
                ps.setInt(1, order.getPrice());

                return ps.execute();
            }
        });
    }

    public void newCustomer(int orderId) {
        String createCustomer = "insert into customers(order_id, name, email_address)" +
                " values (?, ?, ?)";
        String nameOfCustomer = "Customer" + orderId;
        String emailAddress = nameOfCustomer + "@mail.ru";
        jdbcTemplate.update(createCustomer, orderId, nameOfCustomer, emailAddress);
    }

    public List<Orders> findAll() {
        return jdbcTemplate.query("select * from orders", this::mapRowToOrders);
    }

    public Orders findById(Integer id){
        String sql = "select * from orders where order_id = ?";
        try {
            return (Orders) this.jdbcTemplate.queryForObject(
                    sql, new Object[]{id}, this::mapRowToOrders);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
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
