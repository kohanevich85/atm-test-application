package com.kohanevich.annotation.validator;

import com.kohanevich.annotation.PinCode;
import com.kohanevich.entity.Card;
import com.kohanevich.repository.CardRepository;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.kohanevich.form.Parameters.CARD_NUMBER;

/**
 * Created by Denis on 6/12/2016
 */
public class PinCodeValidator implements ConstraintValidator<PinCode, Integer> {
    @Inject private CardRepository cardRepository;
    @Inject private HttpSession httpSession;

    @Override
    public void initialize(PinCode constraintAnnotation) {
        //NOP
    }

    @Override
    public boolean isValid(Integer input, ConstraintValidatorContext context) {
        String cardNumber = (String) httpSession.getAttribute(CARD_NUMBER);
        Card card = cardRepository.getCardByNumber(cardNumber);
        if (input == null || card == null || !input.equals(card.getPinCode())) {
            cardRepository.incrementAttempt(cardNumber);
            return false;
        } else {
            cardRepository.invalidateAttempt(cardNumber);
            return true;
        }
    }
}
