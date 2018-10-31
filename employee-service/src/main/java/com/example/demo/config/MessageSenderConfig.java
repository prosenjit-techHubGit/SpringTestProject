package com.example.demo.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.messaging.EmployeeMessgaeSender;

@Configuration
public class MessageSenderConfig {

	@Bean
	public Exchange eventExchange() {
		return new TopicExchange("eventExchange");
	}

	@Bean
	public EmployeeMessgaeSender employeeMessageSender(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
		return new EmployeeMessgaeSender(rabbitTemplate, eventExchange);
	}

}
