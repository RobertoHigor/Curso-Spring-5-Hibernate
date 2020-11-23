package com.robertohigor.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertohigor.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Método customizado para ordenar por nome
	// De acordo com o nome do método, o Spring JPA irá criar a query apropriada
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
