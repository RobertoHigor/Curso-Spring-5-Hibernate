package br.com.ilovecode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// Checar se apontam para o mesmo endereço de memória
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nApontando para o mesmo objeto: " + result);
		System.out.println("\nEndereço de memória do theCoach: " +theCoach);
		System.out.println("\nEndereço de memória do alphaCoach: " + alphaCoach + "\n");
		
		context.close();
	}

}
