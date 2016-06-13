package com.kohanevich.annotation;

import com.kohanevich.annotation.validator.CardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Denis on 6/12/2016
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {CardNumberValidator.class})
public @interface CardNumber {
    String message() default "card.number.invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
