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
@Constraint(validatedBy = CheckAlphabeticValidator.class)
@Documented
public @interface CheckAlphabetic {

    String message() default "Text must be alphabetic.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
