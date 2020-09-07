package com.robertohigor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robertohigor.entity.Customer;
import com.robertohigor.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Por não utilizar mais o DAO diretamente, não é necessário injeta-lo.
	//@Autowired // Spring dependency injection
	//private CustomerDAO customerDAO;
	
	// Agora é injetado o CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// Pegar e Adicionar ao model os Customers do DAO.
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}

