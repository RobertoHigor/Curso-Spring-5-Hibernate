package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.robertohigor.hibernate.entity.Course;
import com.robertohigor.hibernate.entity.Instructor;
import com.robertohigor.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml") // O nome � opcional
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {			
		// Iniciando a transa��o
			session.beginTransaction();	
			
		// Retornar um Instrutor e seus cursos
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// No Lazy, ele ir� realizar um select de Instructor e InstructorDetails
			System.out.println("Meu app: Instructor: " + tempInstructor);
			
			// Option 1: session.get
			// Retornando cursos antes da sess�o fechar
			System.out.println("Meu app: Courses: " + tempInstructor.getCourses());
			
			
		// Finalizando a transa��o
			
			session.getTransaction().commit();
			
			// Ao fechar a sess�o no LAZY, o Hibernate ir� lan�ar uma exception
			// Pois ele precisa realizar outra consulta no banco de dados,
			// e nesse caso a sess�o est� fechada
			session.close();

			System.out.println("\nMeu app: A sess�o foi fechada");
			// Cursos do Instrutor
			// No Lazy, nessa etapa ser� realizado o select de cursos. 
			// No Eager, os cursos j� ter�o sido carregados ao retornar o instrutor.
			
			// Por�m nesse caso, como j� foi feito o select anteriormente, o Lazy ir� 
			// Apenas carregar os dados da mem�ria
			System.out.println("Meu app: Courses: " + tempInstructor.getCourses());
			
			System.out.println("Meu app: Done");
		}finally {
			// clean up code
			session.close();
			factory.close();
		}
	}
}
