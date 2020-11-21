package com.robertohigor.springbootrestcrud.dao;

import java.util.List;

import com.robertohigor.springbootrestcrud.entity.Employee;

public interface EmployeeDAO {

	// Listar todos
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
