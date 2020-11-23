package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Course;
import com.robertohigor.hibernate.entity.Instructor;
import com.robertohigor.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml") // O nome é opcional
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
		//Criar e associar os objetos
			Instructor tempInstructor = new Instructor("Mike", "Wazowski", "marby@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://luv2code.com/youtube",
					"Scare");
			// Associando o instructor detail na memória
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
		// Inicando a transação
			session.beginTransaction();

			/*
			 * Salvando o Instructor
			 * Pelo fato dos objetos estarem relacionados, isso também irá salvar
			 * o Instructor Detail por conta do Cascade
			 */
			System.out.println("Salvando Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			// clean up code
			session.close();
			factory.close();
		}
	}
}
