package com.kohanevich.service;

import com.kohanevich.entity.Card;
import com.kohanevich.repository.CardRepository;
import com.kohanevich.repository.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by Denis on 6/13/2016
 */
@Service
public class CardServiceImpl implements CardService {
    @Inject
    private CardRepository cardRepository;
    @Inject
    private TransactionTemplate transactionTemplate;
    @Inject
    private OperationRepository operationRepository;

    public Card withdraw(Integer id, BigDecimal amount) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                cardRepository.updateCardBalance(id, amount);
                operationRepository.createWithdrawOperation(id, amount);
            }
        });
        return cardRepository.getCardById(id);
    }
}
