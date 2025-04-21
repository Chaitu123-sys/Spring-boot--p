package com.example.Crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crud.Entity.Employee;
import com.example.Crud.Repository.EmployeeRepository;


import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeerepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return employeerepository.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeerepository.save(employee);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		employeerepository.deleteById(id);
	}

}
