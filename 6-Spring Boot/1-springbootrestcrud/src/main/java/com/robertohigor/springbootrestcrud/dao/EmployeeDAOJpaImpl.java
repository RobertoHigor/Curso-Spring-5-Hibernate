package com.robertohigor.springbootrestcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.robertohigor.springbootrestcrud.entity.Employee;

/*
 * Essa é a implementação 2, utilizando a API padrão do JPA
 */

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// Criar query
		Query theQuery = entityManager.createQuery("from Employee");
		 
		// Executar e receber resultado
		@SuppressWarnings("unchecked")
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		// Método do JPA para pegar o ID gerado pelo banco
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery(
				"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",  theId);
		theQuery.executeUpdate();

	}

}
