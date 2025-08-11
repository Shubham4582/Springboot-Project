package com.Springboot_Demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Employee_DAO {

    @Autowired
    private Employee_JPA jpa;

    public Employee saveEmployee(Employee e) {
        return jpa.save(e);
    }

    public List<Employee> getAllEmployees() {
        return jpa.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return jpa.findById(id);
    }

    public void deleteEmployee(int id) {
        jpa.deleteById(id);
    }

    public List<Employee> getEmployeesByName(String name) {
        return jpa.findByName(name);
    }
}
