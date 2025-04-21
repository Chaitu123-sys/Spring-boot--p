package com.example.Crud.service;

import java.util.List;
import java.util.Optional;

import com.example.Crud.Entity.Employee;

public interface EmployeeService {
	
public List<Employee> findAll();
	
	public Optional<Employee> findById(int id);
	
	public Employee save(Employee employee);
	
	public void deleteById(int id);

}
