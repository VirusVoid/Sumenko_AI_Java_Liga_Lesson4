package com.example.service;

import com.example.service.dao.OrderDAO;
import com.example.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private OrderDAO orderDAO;
	private OrderService service;
	//private OrderServiceForRep orderServiceForRep;
	//

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	/*@PostConstruct
	private void initDb() {
		Orders order1 = new Orders(8, "nrkd",68);
		Orders order2 = new Orders(9, "nrk",7);


		service.createOrder(order1);
		service.createOrder(order2);
	}*/

}
