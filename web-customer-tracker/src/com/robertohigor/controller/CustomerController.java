package com.robertohigor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// Criar atributo model e ligar os dados do formulário
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		// Salvar o Customer utilizando o service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		// Buscar o customer pelo id e adicionar a model
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		
		// Redirecionar para o formulário populado com a model
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}

