package com.robertohigor.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * IgnoreProperties servem para evitar erros no sistema caso novas propriedades sejam adicionadas ao JSON,
 * não sendo necessário atualizar a classe para que tudo volte a funcionar.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	
	// Nested object
	private Address address;
	// Array
	private String[] languages;
	
	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public Student() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
