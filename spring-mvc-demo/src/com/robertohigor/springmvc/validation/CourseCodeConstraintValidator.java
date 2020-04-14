package com.robertohigor.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	private String coursePrefix;
	
	@Override
	// Pegar o valor da propriedade value
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	@Override
	// O ConstraintValidatorContext é um parâmetro adicional para colocar mensagens de erro adicionais.
	public boolean isValid(String theFormData, ConstraintValidatorContext theConstraintValidatorCOntest) {
		boolean result = true;
		
		if (theFormData != null)
			result = theFormData.startsWith(coursePrefix);
		
		return result;
	}
}
