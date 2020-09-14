package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.aopdemo.aspect.AopExpressions.ForDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n=====>>> Logging to Cloud");
	}
}
