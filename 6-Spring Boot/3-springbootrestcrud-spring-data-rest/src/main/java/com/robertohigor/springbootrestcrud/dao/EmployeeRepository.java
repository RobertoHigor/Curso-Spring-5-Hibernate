package com.robertohigor.springbootrestcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.robertohigor.springbootrestcrud.entity.Employee;

// Basta dizer a entidade e o tipo de chave primária
// Nesse caso, Employee tem chave primaria int (id)
//@RepositoryRestResource(path="members") // rota com nome customizado.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
