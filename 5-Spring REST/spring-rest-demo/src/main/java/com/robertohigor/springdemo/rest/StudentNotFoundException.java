package com.robertohigor.springdemo.rest;

// Exception para caso não encontre o estudante
@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
