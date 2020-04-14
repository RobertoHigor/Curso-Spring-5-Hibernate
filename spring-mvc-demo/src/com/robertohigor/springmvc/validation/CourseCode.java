package com.robertohigor.springmvc.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD })
public @interface CourseCode {

	// Atributos da Annotation. Nesse caso value e message
	public String value() default "LUV";
	public String message() default "must start with LUV";
	
	// definir grupos padrões. Pode agrupar limitações relacionadas
	public Class<?>[] groups() default {};

	/*
	* Definir Payload padrão
	* Serve para prover detalhes sobre o erro de validação
	* (gravidade do erro, código do erro etc)
	*/
	public Class<? extends Payload>[] payload() default {};
}