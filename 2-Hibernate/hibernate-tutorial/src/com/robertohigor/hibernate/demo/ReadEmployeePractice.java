package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Employee;

public class ReadEmployeePractice {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			System.out.println("Criando um objeto de Employee");
			
			Employee theEmployee = new Employee("Marco", "Flavio", "Casas Bahia");
			
			session.beginTransaction(); // Iniciar transação			
			session.save(theEmployee);
			session.getTransaction().commit(); // Commit na transação
			
			System.out.println("Employee salvo: " + theEmployee);
			
			/*
			 * Retornar por ID
			 */
			System.out.println("Retornando usuário salvo");			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee readEmployee = session.get(Employee.class, theEmployee.getId());
			System.out.println("Employee retornado: " + readEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}
}
