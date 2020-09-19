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
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { // Passando o argumento JoinPoint para pegar dados do método
		System.out.println("\n=====>>> performing logging");
		
		// Exibir a assinatura do método com joinPoint
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// Exibir os argumentos do método
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
	
	// Advice @AfterReturning no método findAccounts
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// Exibir qual método para qual método o advice está sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executando @AfterReturning no método: " + method);
	
		// Pós processar os dados (modifica-lo)
		convertAccountNamesToUpperCase(result);
		
		// Exibir os resultados do método chamado
		System.out.println("\n=====>>> result é: " + result);
		
	}
	
	// Após uma exceção
	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")	
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// Exibir qual método para qual método o advice está sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executando @AfterThrowing no método: " + method);
		
		// Realizando um log da exceção
		System.out.println("\n=====>>> A exceção é: " + theExc);
	}
	
	// Finally. Após a execução de um método, tanto no sucesso quanto em uma exception.
	// Esse Advice é executado antes do @AfterThrowing
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// Exibir qual método para qual método o advice está sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executando @After no método: " + method);
	}
	
	// Helpers

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tmp : result) {
			String upperName = tmp.getName().toUpperCase();
			tmp.setName(upperName);
		}
		
	}
	
	
}
