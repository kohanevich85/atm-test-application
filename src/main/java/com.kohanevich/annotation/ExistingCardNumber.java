package com.kohanevich.annotation;

import com.kohanevich.annotation.validator.CardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Shows, that target field has to be validated as email, and it should be unique.
 *
 * @author Maksym Dolia
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {CardNumberValidator.class})
public @interface ExistingCardNumber {
    String message() default "card.number.invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
