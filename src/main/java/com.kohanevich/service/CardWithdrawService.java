package com.kohanevich.service;

import com.kohanevich.repository.CardRepository;
import com.kohanevich.repository.OperationRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by Denis on 6/12/2016
 */
//TODO
@Service
public class CardWithdrawService {
    @Inject
    private CardRepository cardRepository;
    @Inject
    private OperationRepository operationRepository;

    public void withdraw(BigDecimal amount, String cardNumber) {
        // transaction
        cardRepository.withdrawMoney(amount, cardNumber);
        operationRepository.addWithdrawOperation(/*id*/1, amount);
    }
}
