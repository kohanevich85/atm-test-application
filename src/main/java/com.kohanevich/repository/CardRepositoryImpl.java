package com.kohanevich.repository;

import com.kohanevich.entity.Card;
import com.kohanevich.repository.mapper.CardMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.math.BigDecimal;

/**
 * Created by Denis on 6/13/2016
 */
@Repository
public class CardRepositoryImpl implements CardRepositoryDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Inject
    public CardRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public Card getCardByNumber(String cardNumber) {
        try {
            String SQL = "SELECT * FROM card WHERE card_number = ?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{cardNumber}, new CardMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Card getCardById(Integer id) {
        try {
            String SQL = "SELECT * FROM card WHERE id = ?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new CardMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateCardBlock(Integer id) {
        String SQL = "UPDATE card SET blocked = TRUE WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void incrementAttempt(Integer id) {
        String SQL = "UPDATE card SET attempt = attempt + 1 WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void invalidateAttempt(Integer id) {
        String SQL = "UPDATE card SET attempt = 0 WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updateCardBalance(Integer id, BigDecimal amount) {
        String SQL = "UPDATE card SET balance = balance - ? WHERE id = ?";
        jdbcTemplate.update(SQL, amount, id);
    }
}
