package com.kohanevich.annotation.validator;

import com.kohanevich.annotation.ValidAmount;
import com.kohanevich.entity.Card;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

import static com.kohanevich.form.Parameters.CARD;

/**
 * Created by Denis on 6/13/2016
 */
public class WithdrawAmountValidator implements ConstraintValidator<ValidAmount, Integer> {
    @Inject private HttpSession httpSession;

    @Override
    public void initialize(ValidAmount constraintAnnotation) {
        //NOP
    }

    @Override
    public boolean isValid(Integer input, ConstraintValidatorContext context) {
        Card card = (Card) httpSession.getAttribute(CARD);
        return input != null && input > 0 &&
                card.getAmount().compareTo(new BigDecimal(input)) > 0;
    }
}
