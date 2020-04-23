package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Instructor;
import com.robertohigor.hibernate.entity.InstructorDetail;

public class DeleteDemo {
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml") // O nome é opcional
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		
		// Inicando a transação
			session.beginTransaction();
			
		// Retornar e remover o Instructor
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
		
			System.out.println("Instrutor encontrado: " + tempInstructor);
			if (tempInstructor != null) {
				System.out.println("Removendo: " + tempInstructor);
				//OBS: Também irá remover InstructorDetails por conta do Cascade
				session.delete(tempInstructor);
			}
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}
