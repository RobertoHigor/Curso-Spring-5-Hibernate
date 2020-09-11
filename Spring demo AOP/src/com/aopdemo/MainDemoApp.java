package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Chamar o método
		theAccountDAO.addAccount();
		
		// Chamar novamente para checar o AOP
		theAccountDAO.addAccount();
		
		context.close();

	}

}
