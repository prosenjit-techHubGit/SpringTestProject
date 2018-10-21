package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
