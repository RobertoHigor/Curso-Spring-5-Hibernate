package com.robertohigor.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Student;

public class QueryStudentDemo {
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml") // O nome é opcional
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
		
		/*
		 *  Query de todos os estudants
		 */
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
		/*
		 *  Query de students: lastname='Duck'
		 */
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			System.out.println("\n\nEstudantes com o sobrenome Duck");
			displayStudents(theStudents);
		
		/*
		 * Query students: lastName 'Duck' OR firstName='Mario'
		 */
			theStudents = session.createQuery("from Student s where"
					+ " s.lastName='Duck' OR s.firstName='Mario'").getResultList();
			
			System.out.println("\n\nEstudantes com o sobrenome Duck OU o nome Mario");
			displayStudents(theStudents);
			
		/*
		 * Query estudantes com o email LIKE '%email.com'
		 */
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%email.com'").getResultList();
			System.out.println("\n\nEstudantes com o email %@email.com");
			displayStudents(theStudents);
			
		
		// Commit na transação
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		// Exibir Students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}
