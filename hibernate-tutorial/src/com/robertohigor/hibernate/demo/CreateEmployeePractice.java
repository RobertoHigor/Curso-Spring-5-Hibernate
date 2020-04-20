package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Employee;

public class CreateEmployeePractice {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			System.out.println("Criando um objeto de Employee");
			
			Employee theEmployee = new Employee("Jos�", "Mardo", "Americanas");
			
			session.beginTransaction(); // Iniciar transa��o			
			session.save(theEmployee);
			session.getTransaction().commit(); // Commit na transa��o
			
			System.out.println("Employee salvo: " + theEmployee);
			
		}finally {
			factory.close();
		}
	}
}
