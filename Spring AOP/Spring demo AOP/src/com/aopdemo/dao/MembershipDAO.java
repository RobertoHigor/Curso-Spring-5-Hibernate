package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	// Não ativa a pointcut expression caso o retorno não seja Boolean
	public boolean addSillyMember() {
		System.out.println(getClass() + ": ADDING MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": Going to sleep");
	}
}
