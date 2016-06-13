package com.kohanevich.service;

import com.kohanevich.entity.Card;
import com.kohanevich.repository.CardRepositoryDao;
import com.kohanevich.repository.OperationRepositoryDao;
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
    private CardRepositoryDao cardRepositoryDao;
    @Inject
    private TransactionTemplate transactionTemplate;
    @Inject
    private OperationRepositoryDao operationRepositoryDao;

    public Card withdraw(Integer id, BigDecimal amount) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                cardRepositoryDao.updateCardBalance(id, amount);
                operationRepositoryDao.createWithdrawOperation(id, amount);
            }
        });
        return cardRepositoryDao.getCardById(id);
    }
}
