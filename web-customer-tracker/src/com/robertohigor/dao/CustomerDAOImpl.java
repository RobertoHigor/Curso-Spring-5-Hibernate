package com.robertohigor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query; // Import a partir do Hibernate 5.2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.robertohigor.entity.Customer;

@Repository // Annotation para DAO. Agora o spring consgue encontrar esse DAO.
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired // Injetar session factory
	private SessionFactory sessionFactory;

	@Override
	@Transactional // Para que o Spring gerencie as transações (begin e end)
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
