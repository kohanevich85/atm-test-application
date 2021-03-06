package com.kohanevich.annotation.validator;

import com.kohanevich.annotation.PinCode;
import com.kohanevich.entity.Card;
import com.kohanevich.repository.CardRepository;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.kohanevich.form.Parameters.CARD;
import static com.kohanevich.form.Parameters.CARD_NUMBER;

/**
 * Created by Denis on 6/12/2016
 */
public class PinCodeValidator implements ConstraintValidator<PinCode, Integer> {
    @Inject private HttpSession httpSession;
    @Inject private CardRepository cardRepository;

    @Override
    public void initialize(PinCode constraintAnnotation) {
        //NOP
    }

    @Override
    public boolean isValid(Integer input, ConstraintValidatorContext context) {
        String cardNumber = (String) httpSession.getAttribute(CARD_NUMBER);
        Card card = cardRepository.getCardByNumber(cardNumber);
        httpSession.setAttribute(CARD, card);
        if (card == null) return false;
        if (input == null || !input.equals(card.getPinCode())) {
            cardRepository.incrementAttempt(card.getId());
            return false;
        } else {
            cardRepository.invalidateAttempt(card.getId());
            return true;
        }
    }
}
