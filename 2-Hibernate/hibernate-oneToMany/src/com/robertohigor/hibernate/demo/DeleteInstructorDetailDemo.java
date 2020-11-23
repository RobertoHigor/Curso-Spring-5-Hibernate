package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Instructor;
import com.robertohigor.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // O nome é opcional
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

		// Inicando a transação
			session.beginTransaction();

			// Recuperar um objeto de Instructor Detail
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// Imprimir o Instrutor associado
			System.out.println("O Instrutor associado: " + tempInstructorDetail.getInstructor());
			
			// Remover o objeto associado
			// Quebrar o link bi-directional
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			// Remover o InstructorDetail
			// Por conta do Cascade, também será removido o Instrutor associado
			System.out.println("Deletando o tempInstructorDetail");
			session.delete(tempInstructorDetail);
			
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
