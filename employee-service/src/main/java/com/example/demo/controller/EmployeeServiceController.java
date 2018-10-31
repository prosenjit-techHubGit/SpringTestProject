package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Employee;

import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeServiceController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")

	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();

	}
	
	@GetMapping("/employee/{email}")

	public Employee getAllEmployees(@PathVariable String email) {

		return employeeService.getAllEmployeeByEmail(email);

	}
	
	
	

}
