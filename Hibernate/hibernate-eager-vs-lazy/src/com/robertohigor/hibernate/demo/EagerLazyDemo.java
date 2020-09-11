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
			
			// No Lazy, ele irá realizar um select de Instructor e InstructorDetails
			System.out.println("Meu app: Instructor: " + tempInstructor);
			
			// Option 1: session.get
			// Retornando cursos antes da sessão fechar
			System.out.println("Meu app: Courses: " + tempInstructor.getCourses());
			
			
		// Finalizando a transação
			
			session.getTransaction().commit();
			
			// Ao fechar a sessão no LAZY, o Hibernate irá lançar uma exception
			// Pois ele precisa realizar outra consulta no banco de dados,
			// e nesse caso a sessão está fechada
			session.close();

			System.out.println("\nMeu app: A sessão foi fechada");
			// Cursos do Instrutor
			// No Lazy, nessa etapa será realizado o select de cursos. 
			// No Eager, os cursos já terão sido carregados ao retornar o instrutor.
			
			// Porém nesse caso, como já foi feito o select anteriormente, o Lazy irá 
			// Apenas carregar os dados da memória
			System.out.println("Meu app: Courses: " + tempInstructor.getCourses());
			
			System.out.println("Meu app: Done");
		}finally {
			// clean up code
			session.close();
			factory.close();
		}
	}
}
