package com.example.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.EmployeeMessageConsumer;
import com.example.demo.service.messaging.EmployeeMessgaeSender;

@RunWith(SpringRunner.class)
public class EmployeeMessagingIntegrationTest {
	
	 @TestConfiguration
	    static class EmployeeMessagingImplTestContextConfiguration {
	  
	        @Bean
	        public EmployeeMessgaeSender employeeMessageSender() {
	            return new EmployeeMessgaeSender(rabbitTemplate(), eventExchange());
	        }
	        @Bean
	    	public Exchange eventExchange() {
	    		return new TopicExchange("eventExchange");
	    	}
	        
	        @Bean
	    	public RabbitTemplate rabbitTemplate() {
	    		return new RabbitTemplate();
	    	}
	        
	        @Bean
	    	public EmployeeMessageConsumer messageConsumer() {
	    		return new EmployeeMessageConsumer();
	    	}
	    }
	
	
	EmployeeMessgaeSender messageSender;
	
	
	@Test
	public void validateMessaging() {
		
		messageSender.addEmployee();
		
		
	}

}
