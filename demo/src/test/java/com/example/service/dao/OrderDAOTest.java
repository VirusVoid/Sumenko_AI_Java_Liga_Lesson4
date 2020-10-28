package com.example.service.dao;

import com.example.service.config.WebConfiguration;
import com.example.service.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Тестирование уровня DAO
 */
class OrderDAOTest {

    private OrderDAO orderDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private KeyHolder keyHolder = new WebConfiguration().keyHolder();

    @Test
    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        orderDAO = new OrderDAO(jdbcTemplate, keyHolder);
    }

    @Test
    void createOrder() {
        Order order = Order.builder()
                .customer_id(1)
                .name("first")
                .price(400)
                .build();
        Integer id = 1;
        Mockito.when(keyHolder.getKey()).thenReturn(id);
        assertEquals(id, orderDAO.createOrder(any(Order.class)).getId());
        verify(keyHolder, times(1)).getKey();
        verifyNoMoreInteractions(keyHolder);
    }
}