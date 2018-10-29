package com.example.demo.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;





@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Test
	
	public void testRepoFind() {
		Employee alex = new Employee("alex","ales.email@email.com",null,null,null);
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    Employee found = employeeRepository.findByEmail(alex.getEmail());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(alex.getName());
		
		
		
	}
	
	

}
