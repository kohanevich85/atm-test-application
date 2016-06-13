package com.kohanevich.annotation;

import com.kohanevich.annotation.validator.PinCodeValidator;

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
@Constraint(validatedBy = {PinCodeValidator.class})
public @interface PinCode {
    String message() default "error.pin.code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
