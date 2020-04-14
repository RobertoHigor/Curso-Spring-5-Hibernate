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
	
	// definir grupos padr�es. Pode agrupar limita��es relacionadas
	public Class<?>[] groups() default {};

	/*
	* Definir Payload padr�o
	* Serve para prover detalhes sobre o erro de valida��o
	* (gravidade do erro, c�digo do erro etc)
	*/
	public Class<? extends Payload>[] payload() default {};
}