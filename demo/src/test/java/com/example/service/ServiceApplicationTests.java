package com.example.service;

import com.example.service.dao.OrderDAO;
import com.example.service.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {"com.example.service.dao.OrderDAO"})
class ServiceApplicationTests {

	@Autowired
	private OrderDAO orderDAO;
	private OrderService service;

	@Test
	void contextLoads() {
	}

}
