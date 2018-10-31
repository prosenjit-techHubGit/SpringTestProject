package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Employee;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.messaging.EmployeeMessgaeSender;

@RestController
public class EmployeeServiceController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeMessgaeSender employeeMessageSender;
	
	@GetMapping("/all")

	public List<Employee> getAllEmployees() {
		
		employeeMessageSender.addEmployee();

		return employeeService.getAllEmployees();

	}
	
	@GetMapping("/employee/{email}")

	public Employee getAllEmployees(@PathVariable String email) {

		return employeeService.getAllEmployeeByEmail(email);

	}
	
	
	

}
