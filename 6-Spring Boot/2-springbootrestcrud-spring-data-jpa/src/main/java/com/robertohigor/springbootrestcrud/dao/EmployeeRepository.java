package com.robertohigor.springbootrestcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertohigor.springbootrestcrud.entity.Employee;

// Basta dizer a entidade e o tipo de chave primária
// Nesse caso, Employee tem chave primaria int (id)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
