package com.kohanevich.annotation.validator;

import com.kohanevich.annotation.CardNumber;
import com.kohanevich.entity.Card;
import com.kohanevich.repository.CardRepository;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Denis Kohanevich
 */
public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {

    @Inject private CardRepository cardRepository;

    @Override
    public void initialize(CardNumber constraintAnnotation) {
        //NOP
    }

    @Override
    public boolean isValid(String cardNumber, ConstraintValidatorContext context) {
        cardNumber = cardNumber.replace(",", "");
        if (cardNumber == null || cardNumber.length() != 16) return false;
        Card card = cardRepository.getCardByNumber(cardNumber);
        return card != null && !card.isBlocked();
    }
}
