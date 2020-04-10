package com.robertohigor.springmvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message="é obrigatório")
	@Size(min=1, message="é obrigatório")
	private String lastName;
	
	@NotNull(message="é obrigatório")
	@Min(value=0, message="O valor deve ser maior ou igual a zero")
	@Max(value=10, message="O valor deve ser maior ou igual a 10")
	private Integer freePasses;
	
	// Validando com expressão regular.
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="somente 5 caracteres/dígitos")
	private String postalCode;
	
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
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
