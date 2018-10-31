package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMessageConsumer {

	private Logger logger = LoggerFactory.getLogger(EmployeeMessageConsumer.class);

	@RabbitListener(queues = "orderServiceQueue")
	public void receive(String message) {
		logger.info("Received message '{}'", message);
	}

}
