package com.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// Criar lista de Accounts e retornar
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Maria", "Gold");
		Account temp3 = new Account("Jesse", "Platinum");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my db work: adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWOrk");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
