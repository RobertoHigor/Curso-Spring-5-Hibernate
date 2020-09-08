package com.robertohigor.dao;

import java.util.List;

import com.robertohigor.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public Object saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
