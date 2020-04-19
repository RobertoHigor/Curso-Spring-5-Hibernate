package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // O nome é opcional
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Criando 3 Student...");
			Student tempStudent1 = new Student("Martin", "Mio", "exemplo4@email.com");
			Student tempStudent2 = new Student("John", "Wall", "exemplo2@email.com");
			Student tempStudent3 = new Student("Mario", "Wall", "exemplo3@email.com");

// Iniciando a transação e salvando o objeto
			session.beginTransaction();
			System.out.println("Salvando o student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
// Commit na transação
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
