package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // Para que a classe escute as chamadas
@Component
@Order(2)
public class DemoLoggingAspect {
	// Aqui são colocados os advices
	// Cada advice recebe como argumento a assinatura de qual método eles irão monitorar.
	
	/*
	* Esse método irá ser chamado ANTES da execução de qualquer método com essa assinatura
	*
	* Match na classe específica
	* @Before("execution(public void com.aopdemo.dao.AccountDAO.addAccount())") 
	* 
	* Match em qualquer método que comece com add
	* @Before("execution(void add*())") 
	* 
	* Match em qualquer método que comece com add e tenha qualquer retorno.
	* @Before("execution(* add*())") 
	* 
	* Apenas métodos com argumento do tipo Account
	* @Before("execution(* add*(com.aopdemo.Account, ..))") 
	* 
	* Match em qualquer método que comece com add, tendo qualquer retorno e argumentos.
	* @Before("execution(* add*(..))") /
	 */
	
	@Before("com.aopdemo.aspect.AopExpressions.ForDaoPackageNoGetterSetter()") // Match em qualquer método do pacote dao
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> performing logging");
	}
	

	
	
}
