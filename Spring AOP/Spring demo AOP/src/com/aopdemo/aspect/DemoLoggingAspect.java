package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

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
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { // Passando o argumento JoinPoint para pegar dados do m�todo
		System.out.println("\n=====>>> performing logging");
		
		// Exibir a assinatura do m�todo com joinPoint
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// Exibir os argumentos do m�todo
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				// Downcast e exibir dados da conta
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name:" + theAccount.getName());
				System.out.println("account level:" + theAccount.getLevel());
				
			}
		}
	}
	
	// Advice @AfterReturning no m�todo findAccounts
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// Exibir qual m�todo para qual m�todo o advice est� sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executando @AfterReturning no m�todo: " + method);
	
		// P�s processar os dados (modifica-lo)
		convertAccountNamesToUpperCase(result);
		
		// Exibir os resultados do m�todo chamado
		System.out.println("\n=====>>> result �: " + result);
		
	}
	
	// Ap�s uma exce��o
	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")	
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// Exibir qual m�todo para qual m�todo o advice est� sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executando @AfterThrowing no m�todo: " + method);
		
		// Realizando um log da exce��o
		System.out.println("\n=====>>> A exce��o �: " + theExc);
	}
	
	// Finally. Ap�s a execu��o de um m�todo, tanto no sucesso quanto em uma exception.
	// Esse Advice � executado antes do @AfterThrowing
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// Exibir qual m�todo para qual m�todo o advice est� sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executando @After no m�todo: " + method);
	}
	
	// Helpers

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tmp : result) {
			String upperName = tmp.getName().toUpperCase();
			tmp.setName(upperName);
		}
		
	}
	
	
}
