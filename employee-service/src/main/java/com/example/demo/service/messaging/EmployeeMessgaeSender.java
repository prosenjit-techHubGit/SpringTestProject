package com.example.demo.service.messaging;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;





public class EmployeeMessgaeSender {
	
	 private final RabbitTemplate rabbitTemplate;

	  private final Exchange exchange;

	  public EmployeeMessgaeSender(RabbitTemplate rabbitTemplate, Exchange exchange) {
	    this.rabbitTemplate = rabbitTemplate;
	    this.exchange = exchange;
	  }

	  public void addEmployee() {
	    // ... do some database stuff
	    String routingKey = "customer.created";
	    String message = "customer created";
	    rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
	  }
	

}
