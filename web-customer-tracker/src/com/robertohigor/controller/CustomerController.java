package com.robertohigor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robertohigor.dao.CustomerDAO;
import com.robertohigor.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired // Spring dependency injection
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// Pegar e Adicionar ao model os Customers do DAO.
		List<Customer> theCustomers = customerDAO.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}

