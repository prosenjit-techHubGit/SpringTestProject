package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.controller.ServiceMainController;
import com.example.demo.domain.Assignment;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.ribbon.config.RibbonClientConfig;

@EnableConfigurationProperties
//@EnableDiscoveryClient
//@EnableEurekaClient
//@EnableFeignClients
@EnableCircuitBreaker
@EnableRabbit
//@EnableHystrix
//@RibbonClient(name = "address-service")
//@RibbonClient(name = "assignment-service-local")
@SpringBootApplication
public class Service1Application {
	private static Logger logger = LoggerFactory.getLogger(ServiceMainController.class);

/*	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
//	@PostConstruct
//	void init() {
		
		

	/*	Project project1 = projectRepository.save(new Project("Project1", new java.sql.Date(System.currentTimeMillis()),
				new java.sql.Date(System.currentTimeMillis())));
		
		
		
		Project project2 = projectRepository.save(new Project("Project2", new java.sql.Date(System.currentTimeMillis()),
				new java.sql.Date(System.currentTimeMillis()))); */

/*	Set<Project> projects = new HashSet<Project>(Arrays.asList(new Project[] { project1, project2 }));
		System.out.println(project1.getProjectName()); 

   employeeRepository.save(new Employee("Prosenjit","Prosenjit@email.com","8617099972","EAS-IPM","Sabari"));
		employeeRepository.save(new Employee("Nazeef","Nazeef@email.com","1234567891","EAS-IPM","Prosenjit"));
		
		Project project = new Project("Project1", new java.sql.Date(System.currentTimeMillis()),
				new java.sql.Date(System.currentTimeMillis()));
		project.setAssignees(new HashSet<Employee>(employeeRepository.findAll()));
		projectRepository.save(project); */
		

	//}
}
