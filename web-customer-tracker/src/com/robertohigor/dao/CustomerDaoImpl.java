package com.robertohigor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query; // Import a partir do Hibernate 5.2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.robertohigor.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired // Injetar session factory
	private SessionFactory sessionFactory;

	@Override // Foi removido a @Transactional por utilizar service layer (transferida para l�)	
	public List<Customer> getCustomers() {
		// Pegar a sess�o hibernate atual
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Criar e executar um query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		List<Customer> customers = theQuery.getResultList();
		
		// Retornar o resultado
		return customers;
	}


	@Override
	public Object saveCustomer(Customer theCustomer) {
		// Pegar a sess�o hibernate atual
		Session currentSession = sessionFactory.getCurrentSession();		
		// Salvar ou atualizar.
		// Caso exista algum valor na chave prim�ria, � executado o m�todo de atualizar.
		currentSession.saveOrUpdate(theCustomer);
		return null;
	}


	@Override
	public Customer getCustomer(int theId) {
		// Pegar a sess�o hibernate e depois retornar os dados do banco de dados
		Session currentSession = sessionFactory.getCurrentSession();		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Deletar o objeto com a chave prim�ria
		@SuppressWarnings("rawtypes")
		Query theQuery = 
		currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
