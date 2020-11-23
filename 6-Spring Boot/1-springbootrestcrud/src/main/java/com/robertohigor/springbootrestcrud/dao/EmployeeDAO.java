package com.robertohigor.springbootrestcrud.dao;

import java.util.List;

import com.robertohigor.springbootrestcrud.entity.Employee;
/*
 * Existem 3 versões do DAO
 * 1. Com Hibernate nativo na classe EmployeeDAOHibernateImpl
 * 2. Com a API padrão JPA na classe EmployeeDAOJpaImpl, com a vantagem de facilitar a troca de implementações JPA
 * 3. Utilizando Spring Data JPA, não necessitando de implementação
 */
public interface EmployeeDAO {

	// Listar todos
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
