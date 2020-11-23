package com.robertohigor.springbootrestcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.robertohigor.springbootrestcrud.entity.Employee;

/*
 * Essa é a implementação 1, utilizando EntityManager com a API nativa do Hibernate
 */
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	// Constructor Injection
	/* 
	 * O EntityManager é criado pelo Spring Boot. Por ter apenas um construtor, a annotation @AutoWired é opcional.
	 * Nesse caso, pode ser utilizr qualquer tipo de injeção de dependência, sendo a do construtor apenas um exemplo.
	 */
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// Pegando a sessão hibernate atual
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		// Executar e receber o resultado
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class,  theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Irá salvar se o id for 0 ou null
		currentSession.saveOrUpdate(theEmployee);		
	}

	@Override
	public void deleteById(int theID) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",  theID);
		
		theQuery.executeUpdate();
				
				
		
	}

}
