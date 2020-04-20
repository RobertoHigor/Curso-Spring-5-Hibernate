package com.robertohigor.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Employee;

public class DeleteEmployeePractice {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			int employeeId = 2;
			/*
			 * remover empregado por referência ao objeto
			 */
			session.beginTransaction();
			
			System.out.println("Apagando empregado com o id: " + employeeId);
			Employee theEmployee = session.get(Employee.class, employeeId);
			session.delete(theEmployee);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}
}
