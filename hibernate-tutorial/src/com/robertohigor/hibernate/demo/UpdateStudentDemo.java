package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // O nome é opcional
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			/*
			 * Atualizar um usuário pelo ID
			 */
			int studentId = 1;
			
			// Ler no banco de dados
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Get Student. Retorna null se não encontrar.
			System.out.println("\nRecebendo o estudante com o id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Atualizando Estudante");
			myStudent.setFirstName("Scooby"); // Atualizando o nome
			
			// Atualizando no banco de dados
			session.getTransaction().commit();
			
			/*
			 * Atualizar múltiplos usuários
			 */
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Atualizando o email de todos os usuários");
			
			session.createQuery("update Student set email='foo@gmail.com'")
				.executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
