package com.robertohigor.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Employee;

public class QueryEmployeePractice {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			/*
			 * Retornar empregados da americanas
			 */
			session.beginTransaction();
			List<Employee> empregados = session.createQuery("from Employee where company='Americanas'").getResultList();

			for (Employee empregado : empregados)
				System.out.println(empregado);			
			System.out.println("Done");
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}
}
