package com.kohanevich.form;

import com.kohanevich.annotation.CardNumber;

/**
 * Created by Denis on 6/11/2016
 */
public class CardNumberForm {

    @CardNumber
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber.replace(",", "");
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
