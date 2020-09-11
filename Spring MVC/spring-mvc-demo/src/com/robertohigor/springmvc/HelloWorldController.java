package com.robertohigor.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
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
		
		String theName = request.getParameter("studentName"); //Ler o par�metro do formul�rio
		theName = theName.toUpperCase();
		
		String result = "Ol�! " + theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("processFormParam")
	public String processFormParam(@RequestParam("studentName") String theName,HttpServletRequest request, Model model) {
		
		//Nesse caso, a vari�vel foi atribuida pelo @RequestParam
		theName = theName.toUpperCase();
		
		String result = "Ol�! @RequestParam: " + theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
}
