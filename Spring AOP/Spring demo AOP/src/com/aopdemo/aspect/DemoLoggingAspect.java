package com.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
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
		myLogger.info("\n=====>>> performing logging");
		
		// Exibir a assinatura do método com joinPoint
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);
		
		// Exibir os argumentos do método
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			// Foi adicionado o toString pois o info() não aceita Object.
			myLogger.info(tempArg.toString()); 
			
			if (tempArg instanceof Account) {
				// Downcast e exibir dados da conta
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name:" + theAccount.getName());
				myLogger.info("account level:" + theAccount.getLevel());
				
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
		myLogger.info("\n=====>>> Executando @AfterReturning no método: " + method);
	
		// Pós processar os dados (modifica-lo)
		convertAccountNamesToUpperCase(result);
		
		// Exibir os resultados do método chamado
		myLogger.info("\n=====>>> result é: " + result);
		
	}
	
	// Após uma exceção
	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")	
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// Exibir qual método para qual método o advice está sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executando @AfterThrowing no método: " + method);
		
		// Realizando um log da exceção
		myLogger.info("\n=====>>> A exceção é: " + theExc);
	}
	
	// Finally. Após a execução de um método, tanto no sucesso quanto em uma exception.
	// Esse Advice é executado APÓS o @AfterThrowing e @AfterReturning.
	// Porém, em versões antes da 5.2 do Spring, ele executava antes.
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// Exibir qual método para qual método o advice está sendo executado
		String method =  theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executando @After no método: " + method);
	}
	
	// @Around advice
	@Around("execution(* com.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoin) throws Throwable {
		
		// Exibir o método em que está sendo executado o advise
		String method =  theProceedingJoin.getSignature().toShortString();
		myLogger.info("\n=====>>> Executando @Around no método: " + method);
		
		// Iniciar o cronômetro
		long begin = System.currentTimeMillis();
		
		// Executar o método
		Object result = theProceedingJoin.proceed();
		
		//Finalizar cronômetro
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
		
		// Retornar para quem chamou o método
		return result;
	}
	
	// Helpers

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tmp : result) {
			String upperName = tmp.getName().toUpperCase();
			tmp.setName(upperName);
		}
		
	}
	
	
}
