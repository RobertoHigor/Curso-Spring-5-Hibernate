package com.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	// Utilizando a API de logging do Java.
	// Como boa prática, se utiliza o nome da própria classe.
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		// Configuração
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
