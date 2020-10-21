package com.example.service.controller;

import com.example.service.model.Orders;
import com.example.service.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderController orderController;

    @MockBean
    OrderService orderService;

    @Test
    void createOrderTest() throws Exception {
        Orders exampleOrder = Orders.builder()
                .customer_name("customerFirst")
                .order_name("testName")
                .price(123)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        orderService.createOrderForCustomer(exampleOrder);
        this.mockMvc.perform(post("/api/v1/order")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(exampleOrder)))
                .andExpect(status().isOk())
                .andDo(print());
        this.mockMvc.perform(post("/api/v1/order")
                .param("customer1", "order1", "75"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}