package com.robertohigor.springmvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message="é obrigatório")
	@Size(min=1, message="é obrigatório")
	private String lastName;
	
	@Min(value=0, message="O valor deve ser maior ou igual a zero")
	@Max(value=10, message="O valor deve ser maior ou igual a 10")
	private int freePasses;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	
}
