package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Para que a classe escute as chamadas
@Component
public class DemoLoggingAspect {
	// Aqui são colocados os advices
	// Cada advice recebe como argumento a assinatura de qual método eles irão monitorar.
	
	// Esse método irá ser chamado ANTES da execução de qualquer método com essa assinatura
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}
