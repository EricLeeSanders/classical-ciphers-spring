package com.ericleesanders.classicalciphers.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckAlphabeticValidator implements ConstraintValidator<CheckAlphabetic, String> {

    @Override
    public void initialize(CheckAlphabetic constraintAnnotation) {

    }

    @Override
    public boolean isValid(String text, ConstraintValidatorContext context) {

        if (text == null || text.isEmpty()) {
            return false;
        }

        String messageFiltered = text.replaceAll("[^A-Z]", "");

        return messageFiltered.length() == text.length();

    }

}
