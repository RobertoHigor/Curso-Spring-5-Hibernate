package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // O nome é opcional
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// Utilizar o session object para salvar o Java Object
			System.out.println("Criando um novo objeto Student...");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@email.com");

			// Iniciando a transação e salvando o objeto
			session.beginTransaction();
			System.out.println("Salvando o student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// Commit na transação
			session.getTransaction().commit();

			// Ler no banco de dados
			System.out.println("Estudante salvo. Id Gerado: " + tempStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Get Student. Retorna null se não encontrar.
			System.out.println("\nRecebendo o estudante com o id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get completo: " + myStudent);
			
			// No hibernate, mesmo em leituras é realizado uma transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
