package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Course;
import com.robertohigor.hibernate.entity.Instructor;
import com.robertohigor.hibernate.entity.InstructorDetail;

public class GetInstructorCoursesDemo {
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml") // O nome é opcional
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {			
		// Iniciando a transação
			session.beginTransaction();	
			
		// Retornar um Instrutor e seus cursos
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			// Cursos do Instrutor
			System.out.println("Courses: " + tempInstructor.getCourses());
			
		// Finalizando a transação
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			// clean up code
			session.close();
			factory.close();
		}
	}
}
