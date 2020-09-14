package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// Configuração
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Criando os bean
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		Account theAccount = new Account();
		
		
		// Chamadas a métodos
		
		// AccountDAO
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.doWork();
		
		// Getters e Setters
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		context.close();

	}

}
