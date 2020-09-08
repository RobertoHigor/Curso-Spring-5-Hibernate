package com.robertohigor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robertohigor.dao.CustomerDAO;
import com.robertohigor.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional 
	// Para que o Spring gerencie as transações (begin e end)
	// @Transactional foi transferida para a Service Layer.
	public List<Customer> getCustomers() {		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

}
