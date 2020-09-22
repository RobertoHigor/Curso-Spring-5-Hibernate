package com.robertohigor.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// Logger para exibir mensagens
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// Qualquer classe e m�todo no pacote controller
	@Pointcut("execution(* com.robertohigor.controller.*.*(..))")
	private void forControllerPackage() {
	}

	// Qualquer classe e m�todo no pacote service
	@Pointcut("execution(* com.robertohigor.services.*.*(..))")
	private void forServicePackage() {
	}

	// Qualquer classe e m�todo no pacote dao
	@Pointcut("execution(* com.robertohigor.dao.*.*(..))")
	private void forDaoPackage() {
	}
	
	// Controller + service + dao
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// Exibir o m�todo que estamos chamando
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> no @Before: chamando o m�todo: " + theMethod);
		
		// loop para mostrar os argumentos
		Object[] args = theJoinPoint.getArgs();
		for (Object myArgs : args) {
			myLogger.info("=====>> argumento: " + myArgs);
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// Exibir o m�todo que estamos chamando
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> no @AfterReturning: chamando o m�todo: " + theMethod);
		
		// Exibir os dados retornados
		myLogger.info("====> result: " + theResult);
	}

}
