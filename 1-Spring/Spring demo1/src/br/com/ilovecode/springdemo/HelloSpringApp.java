package br.com.ilovecode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrive bean from spring container
		//Você passa a interface Coach como parâmetro do getBean para garantir que é a interface correta
		//Permitindo um cast de BeanNotOfRequiredTypeException se for do tipo errado.
		//Além disso significa que não pode dar cast em ClassCastException em um resultado correto.
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
