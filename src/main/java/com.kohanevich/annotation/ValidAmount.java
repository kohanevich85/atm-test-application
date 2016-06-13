package com.kohanevich.annotation;

import com.kohanevich.annotation.validator.WithdrawAmountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Denis on 6/13/2016
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {WithdrawAmountValidator.class})
public @interface ValidAmount {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
