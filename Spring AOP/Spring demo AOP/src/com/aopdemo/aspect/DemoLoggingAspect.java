package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Para que a classe escute as chamadas
@Component
public class DemoLoggingAspect {
	// Aqui s�o colocados os advices
	// Cada advice recebe como argumento a assinatura de qual m�todo eles ir�o monitorar.
	
	// Esse m�todo ir� ser chamado ANTES da execu��o de qualquer m�todo com essa assinatura
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}
