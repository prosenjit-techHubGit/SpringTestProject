package com.example.demo.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeeServiceIntegrationTest {

	 @TestConfiguration
	    static class EmployeeServiceImplTestContextConfiguration {
	  
	        @Bean
	        public EmployeeService employeeService() {
	            return new EmployeeService();
	        }
	    }
	
	@Autowired
	EmployeeService employeeService;
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Before
	public void setUp() {
	    Employee alex = new Employee("alex","alex@email.com",null,null,null);
	 
	    Mockito.when(employeeRepository.findByEmail(alex.getEmail()))
	      .thenReturn(alex);
	}
	
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
	    String email = "alex@email.com";
	    Employee found = employeeService.getAllEmployeeByEmail(email);
	  
	     assertThat(found.getEmail())
	      .isEqualTo(email);
	 }
	
	
}
