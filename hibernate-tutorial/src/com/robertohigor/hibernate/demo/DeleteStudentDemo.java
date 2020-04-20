package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // O nome é opcional
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			/*
			 * Remover um estudante pelo objeto
			 */
			int studentId = 1;
			
			// Ler no banco de dados
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Get Student. Retorna null se não encontrar.
			System.out.println("\nRecebendo o estudante com o id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// remover o Student
			//System.out.println("Removendo o estudante: " +myStudent);
			//session.delete(myStudent);
			
			/*
			 * Removendo um estudante por um ID especificado.
			 */
			System.out.println("Removendo o estudante id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// Removendo do banco de dados
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
