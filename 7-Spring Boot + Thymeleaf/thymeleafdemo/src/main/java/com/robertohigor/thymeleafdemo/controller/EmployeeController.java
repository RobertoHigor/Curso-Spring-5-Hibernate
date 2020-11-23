package com.robertohigor.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robertohigor.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		// Criar lista de employees
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@email.com");
		Employee emp2 = new Employee(2, "Emma", "Andrews", "emma@email.com");
		Employee emp3 = new Employee(3, "Avani", "Andrews", "avani@email.com");
		
		theEmployees = new ArrayList<>();
		
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// Adicionar a lista no Spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
