package com.kohanevich.repository;

import com.kohanevich.entity.Card;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 6/11/2016
 */
//TODO
@Repository
public class CardRepository {

    private Map<String, Card> cards;

    public CardRepository() {
        initFakeData();
    }

    private void initFakeData() {
        cards = new HashMap<>();
        Card card = new Card();
        card.setCardNumber(1234567890123456L);
        card.setId(1);
        card.setPinCode(1234);
        card.setAmount(new BigDecimal(500));
        card.setAttempt(0);
        cards.put("1234567890123456", card);
    }

    public Card getCardByNumber(String cardNumber) {
        return cards.get(cardNumber);
    }

    public void incrementAttempt(String cardNumber) {
        Card card = cards.get(cardNumber);
        int attempt = card.getAttempt();
        card.setAttempt(++attempt);
        cards.put(cardNumber, card);
    }

    public void invalidateAttempt(String cardNumber) {
        Card card = cards.get(cardNumber);
        card.setAttempt(0);
        cards.put(cardNumber, card);
    }

    public void withdrawMoney(BigDecimal amount, String cardNumber) {
        Card card = cards.get(cardNumber);
        BigDecimal currentAmount = card.getAmount();
        BigDecimal result = currentAmount.subtract(amount);
        card.setAmount(result);
        cards.put(cardNumber, card);
    }

    public void blockCard(String cardNumber) {
        Card card = cards.get(cardNumber);
        card.setBlocked(true);
        cards.put(cardNumber, card);
    }
}
