package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service1ApplicationTests {

	@MockBean
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService employeeService;

	@Test
	public void contextLoads() {
	}

	@Before

	public void before() {
		System.out.println("Test Employee Service - Started");
	}

	@Test

	public void testEmployeeServiceFindAll() {

		when(employeeRepository.findAll()).thenReturn(getEmployeeList());
		assertEquals(1, employeeService.getAllEmployees().size());

	}

	@After

	public void after() {
		System.out.println("Test Employee Service - Completed");
	}

	public List<Employee> getEmployeeList() {

		List<Employee> empList = new ArrayList<Employee>();

		empList.add(new Employee("Prosenjit", "prosenjit.das@email.com", null, null, null));
		empList.add(new Employee("Nazeef", "nazeef@email.com", null, null, null));

		return empList;

	}

}
