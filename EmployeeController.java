package com.example.Crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Crud.Entity.Employee;
import com.example.Crud.service.EmployeeService;

import org.springframework.ui.Model;

@Controller
public class EmployeeController {
	
  
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> emp=employeeservice.findAll();
		model.addAttribute("employees", emp);
	    return "list-emps";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		employeeservice.save(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int theId,Model model) {	
		Optional<Employee> theEmployee=employeeservice.findById(theId);
		model.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int theId) {
		
		employeeservice.deleteById(theId);
		return "redirect:/list";
	}
	
	
}
