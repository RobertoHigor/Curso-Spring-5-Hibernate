package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

		// Match em todas os m�todos do pacote dao
		@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {} // O nome do m�todo aponta para a express�o acima.
		
		/*
		 *  Match em getters e setters
		 */
		@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		// Combinando: incluir pacote e excluir getters e setters
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void ForDaoPackageNoGetterSetter(){}
		
}
