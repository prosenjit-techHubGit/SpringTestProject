package com.example.demo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.EmployeeServiceController;
import com.example.demo.controller.ServiceMainController;
import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeServiceController.class)
public class EmployeeRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService service;

	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

		Employee alex = new Employee("alex", null, null, null, null);
		Employee alex1 = new Employee("alex1", null, null, null, null);

		List<Employee> allEmployees = Arrays.asList(new Employee[] { alex, alex1 });

		Mockito.when(service.getAllEmployees()).thenReturn(allEmployees);

		mvc.perform(get("/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].name", is(alex.getName())));
	}

	@Test
	public void validateEmployeeByEmail() throws Exception {
		Employee prosen = new Employee("prosen", "cosypro@gmail.com", null, null, null);

		// List<Employee> employees = Arrays.asList(new Employee[] {prosen});

		Mockito.when(service.getAllEmployeeByEmail("cosypro@gmail.com")).thenReturn(prosen);

		mvc.perform(get("/employee/cosypro@gmail.com").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.email").value("cosypro@gmail.com"));

	}
}