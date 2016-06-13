package com.kohanevich.service;

import com.kohanevich.entity.Card;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Denis on 6/13/2016
 */
@Service
public interface CardService {
    public Card withdraw(Integer id, BigDecimal amount);
}
