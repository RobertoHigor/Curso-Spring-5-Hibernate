package com.robertohigor.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Student;

public class CreateStudentDemo {
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml") // O nome é opcional
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// Utilizar o session object para salvar o Java Object
			System.out.println("Criando um novo objeto Student...");
			
			Student tempStudent = new Student("Paul", "Wall", "exemplo@email.com");
			
			// Iniciando a transação e salvando o objeto
			session.beginTransaction();
			System.out.println("Salvando o student...");
			session.save(tempStudent);
			
			// Commit na transação
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}
