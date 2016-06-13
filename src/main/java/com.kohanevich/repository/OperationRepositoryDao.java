package com.kohanevich.repository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by Denis on 6/13/2016
 */
@Repository
public interface OperationRepositoryDao {
    public void     createInfoOperation(Integer id);
    public void createWithdrawOperation(Integer id, BigDecimal amount);
}
