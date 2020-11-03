package com.robertohigor.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// Criar object mapper
			ObjectMapper mapper = new ObjectMapper();
			//Ler o JSON e converter para POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("First Name = " + theStudent.getFirstName());
			System.out.println("Last Name = " + theStudent.getLastName());
			System.out.println("City = " + theStudent.getAddress().getCity());			
			for (String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
