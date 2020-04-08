package com.robertohigor.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("processFormModel")
	public String processFormModel(HttpServletRequest request, Model model) {
		
		String theName = request.getParameter("studentName"); //Ler o parâmetro do formulário
		theName = theName.toUpperCase();
		
		String result = "Olá! " + theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
}
