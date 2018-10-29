package com.example.demo.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long empid;
     
	public Employee(String name, String email, String phone, String department, String manager,Project project) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.manager = manager;
		this.project = project;
		//this.projects = projects;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String email, String phone, String department, String manager) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.manager = manager;
		
		// TODO Auto-generated constructor stub
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	/*public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}*/

	private String email;
	private String phone;
	private String department;
	private String manager;
	
	/*@ManyToMany
	@JoinTable(name="emp_proj", joinColumns=@JoinColumn(name="empid"),inverseJoinColumns=@JoinColumn(name="id") )*/
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Project project;

}
