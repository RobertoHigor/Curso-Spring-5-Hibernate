package com.robertohigor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query; // Import a partir do Hibernate 5.2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.robertohigor.entity.Customer;

@Repository // Annotation para DAO. Agora o spring consgue encontrar esse DAO.
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired // Injetar session factory
	private SessionFactory sessionFactory;

	@Override // Foi removido a @Transactional por utilizar service layer (transferida para lá)	
	public List<Customer> getCustomers() {
		// Pegar a sessão hibernate atual
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Criar e executar um query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		
		// Retornar o resultado
		return customers;
	}

}
