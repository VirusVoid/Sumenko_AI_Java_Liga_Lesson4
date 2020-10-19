package com.example.service.controller;

import com.example.service.model.Orders;
import com.example.service.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OrderService orderService;

    @Test
    void createOrderTest() throws Exception {
        Orders exampleOrder = Orders.builder()
                .order_name("testName")
                .price(123)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/api/v1/order")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(exampleOrder)))
                .andExpect(status().isOk())
                .andDo(print());


        verify(orderService, times(1)).createOrderForCustomer(any(Orders.class));
        ResponseEntity result1 = orderService.createOrderForCustomer(exampleOrder);
        assertEquals(result1.getStatusCodeValue(), 200);

        exampleOrder.setOrder_name("hello");
     /*   ResponseEntity answer = orderService.createOrder(exampleOrder);
        assertEquals(answer, true);*/
    }
}