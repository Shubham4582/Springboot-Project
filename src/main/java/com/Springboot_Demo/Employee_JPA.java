package com.Springboot_Demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Employee_JPA extends JpaRepository<Employee, Integer> {

//	public List<Employee> getByName(String name);
	public List<Employee> findByName(String name);

}
