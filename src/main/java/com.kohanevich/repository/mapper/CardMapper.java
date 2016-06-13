package com.kohanevich.repository.mapper;

import com.kohanevich.entity.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Denis on 6/13/2016
 */
public class CardMapper implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Card card = new Card();
        card.setAmount(rs.getBigDecimal("balance"));
        card.setAttempt(rs.getInt("attempt"));
        card.setBlocked(rs.getBoolean("blocked"));
        card.setPinCode(rs.getInt("pin_code"));
        card.setCardNumber(rs.getLong("card_number"));
        card.setId(rs.getInt("id"));
        return card;
    }
}
