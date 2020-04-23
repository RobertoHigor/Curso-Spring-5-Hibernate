package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Instructor;
import com.robertohigor.hibernate.entity.InstructorDetail;

public class GetInstructorDetail {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // O nome é opcional
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

		// Inicando a transação
			session.beginTransaction();

			// Recuperar um objeto de Instructor Detail
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// Imprimir o Instrutor associado
			System.out.println("O Instrutor associado: " + tempInstructorDetail.getInstructor());

		// Commit na transação
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// Lidar com o connection leak
			session.close();
			factory.close();
		}
	}
}
