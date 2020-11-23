package com.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	// Utilizando a API de logging do Java.
	// Como boa pr�tica, se utiliza o nome da pr�pria classe.
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		// Configura��o
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);		
		
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
			
		myLogger.info("\nMain Program: AroundDemoApp");		
		myLogger.info("Calling getFortune");
		
		// Simular exception
		boolean tripWire = true;
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: "+ data);
		myLogger.info("Finished");
		context.close();

	}

}
