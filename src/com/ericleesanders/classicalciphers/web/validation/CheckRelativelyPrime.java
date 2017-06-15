package com.ericleesanders.classicalciphers.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckRelativelyPrimeValidator.class)
@Documented
public @interface CheckRelativelyPrime {
	
	String message() default "Shift must be relatively prime.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

	int stationaryNumber();
}
