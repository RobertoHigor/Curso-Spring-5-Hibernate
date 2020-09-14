package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	// N�o ativa a pointcut expression caso o retorno n�o seja Boolean
	public boolean addSillyMember() {
		System.out.println(getClass() + ": ADDING MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": Going to sleep");
	}
}
