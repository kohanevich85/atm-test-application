package com.kohanevich.repository;

import com.kohanevich.entity.Card;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by Denis on 6/13/2016
 */
@Repository
public interface CardRepositoryDao {
    public Card getCardByNumber(String cardNumber);
    public Card getCardById(Integer id);
    public void updateCardBlock(Integer id);
    public void incrementAttempt(Integer id);
    public void invalidateAttempt(Integer id);
    public void updateCardBalance(Integer id,  BigDecimal amount);
}
