package com.example.demo.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	private Set<Employee> assignees;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectName, Date startDate, Date endDate) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private String projectName;
	private Date startDate;
	private Date endDate;
      
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//@OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	public Set<Employee> getAssignees() {
		return assignees;
	}

	public void setAssignees(Set<Employee> assignees) {
		this.assignees = assignees;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
