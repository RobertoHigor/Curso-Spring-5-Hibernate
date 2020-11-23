package com.robertohigor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.robertohigor.hibernate.entity.Course;
import com.robertohigor.hibernate.entity.Instructor;
import com.robertohigor.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {
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
			
		// option 2: Hibernate Query with HQL
			
		// Retornar um Instrutor e seus cursos
			int theId = 1;
		
			// Query para retornar o instrutor e os cursos
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId",
							Instructor.class);
			
			// Definir os parâmetros da query
			query.setParameter("theInstructorId", theId);
			Instructor tempInstructor = query.getSingleResult();
			
			// No Lazy, ele irá realizar um select de Instructor e InstructorDetails
			System.out.println("Meu app: Instructor: " + tempInstructor);
		
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
