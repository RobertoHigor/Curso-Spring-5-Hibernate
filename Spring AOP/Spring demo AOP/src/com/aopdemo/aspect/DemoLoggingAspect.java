package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // Para que a classe escute as chamadas
@Component
@Order(2)
public class DemoLoggingAspect {
	// Aqui s�o colocados os advices
	// Cada advice recebe como argumento a assinatura de qual m�todo eles ir�o monitorar.
	
	/*
	* Esse m�todo ir� ser chamado ANTES da execu��o de qualquer m�todo com essa assinatura
	*
	* Match na classe espec�fica
	* @Before("execution(public void com.aopdemo.dao.AccountDAO.addAccount())") 
	* 
	* Match em qualquer m�todo que comece com add
	* @Before("execution(void add*())") 
	* 
	* Match em qualquer m�todo que comece com add e tenha qualquer retorno.
	* @Before("execution(* add*())") 
	* 
	* Apenas m�todos com argumento do tipo Account
	* @Before("execution(* add*(com.aopdemo.Account, ..))") 
	* 
	* Match em qualquer m�todo que comece com add, tendo qualquer retorno e argumentos.
	* @Before("execution(* add*(..))") /
	 */
	
	@Before("com.aopdemo.aspect.AopExpressions.ForDaoPackageNoGetterSetter()") // Match em qualquer m�todo do pacote dao
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> performing logging");
	}
	

	
	
}
