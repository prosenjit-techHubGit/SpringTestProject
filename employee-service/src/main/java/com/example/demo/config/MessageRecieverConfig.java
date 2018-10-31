package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.EmployeeMessageConsumer;

@Configuration
public class MessageRecieverConfig {

	/*
	 * @Autowired BindingBuilder bindingBuilder;
	 */

	@Bean
	public Exchange eventExchange() {
		return new TopicExchange("eventExchange");
	}

	@Bean
	public Queue queue() {
		return new Queue("orderServiceQueue");
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange eventExchange) {
		return BindingBuilder.bind(queue).to(eventExchange).with("customer.*");

	}

	@Bean
	public EmployeeMessageConsumer eventReceiver() {
		return new EmployeeMessageConsumer();
	}

}
