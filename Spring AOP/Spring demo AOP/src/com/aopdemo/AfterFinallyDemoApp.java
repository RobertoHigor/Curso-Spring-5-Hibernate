package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// Configuração
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);		
		
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		// Retornar lista de Account
		List<Account> theAccounts = null;
		try {
			// boolean flag para simular exception
			boolean tripWire = false;
			theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\nMain Program caught exception: " + exc);
		}
		
		System.out.println("\n\nMain Program: AfterThrowinggDemoApp");
		System.out.println("---");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		
		
		context.close();

	}

}
