package com.robertohigor.springmvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	* O @InitBinder é pre-processado antes do controller a cada web request
	* Nesse caso, ele pré-processa todos os dados do tipo String e remove os espaços
	*/
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// É a classe do Spring para remover espaços. Nesse caso, os espaços do começo e do final.
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // true = apagar até ficar null
		
		
		/*
		*  Registrar no WebDataBinder o editor customizado que aplica o objeto
		*  stringTrimmerEditor para todas as classes String
		*/
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	/*
	 * A anotação @Valid serve para utilizar regras de validação.
	 * Deve-se colocar o BindingResult sempre após a model
	 */
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		
		System.out.println("Last Name: |" + theCustomer.getLastName() + "|"); // O | é para verificar se tem espaços
		System.out.println("Binding result: " + theBindingResult);
		System.out.println("\n\n\n");
		// Se o resultado possui algum erro, retornar para a mesma página.
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		}		
		return "customer-confirmation";
	}

}
