package com.kohanevich.repository;

import com.kohanevich.entity.Operation;
import com.kohanevich.entity.OperationType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 6/12/2016
 */
//TODO
@Repository
public class OperationRepository {

    private Map<Integer, Operation> operations;

    public OperationRepository() {
        operations = new HashMap<>();
        initFakeData();
    }

    private void initFakeData() {
        Operation operation = new Operation();
        operation.setAmount(new BigDecimal(100));
        operation.setId(1);
        operation.setOperationType(OperationType.WITHDRAW);
        operation.setTime(LocalDateTime.now());
        operations.put(operation.getId(), operation);
    }

    public void addInfoOperation(int cardId) {
        Operation operation = new Operation();
        //operation.setCard(id);
        operation.setOperationType(OperationType.INFO);
        operation.setTime(LocalDateTime.now());
        operations.put(operation.getId(), operation);
    }

    public void addWithdrawOperation(int cardId, BigDecimal amount) {
        // transaction
        Operation operation = new Operation();
        //operation.setCard(id);
        operation.setOperationType(OperationType.WITHDRAW);
        operation.setTime(LocalDateTime.now());
        operation.setAmount(amount);
        operations.put(operation.getId(), operation);
    }
}
