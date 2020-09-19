package com.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	// Utilizando a API de logging do Java.
	// Como boa pr�tica, se utiliza o nome da pr�pria classe.
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		// Configura��o
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);		
		
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
			
		myLogger.info("\nMain Program: AroundDemoApp");		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: "+ data);
		myLogger.info("Finished");
		context.close();

	}

}
