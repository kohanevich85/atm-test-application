package com.kohanevich.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Timestamp;

import static com.kohanevich.entity.OperationType.INFO;
import static com.kohanevich.entity.OperationType.WITHDRAW;
import static java.time.LocalDateTime.now;

/**
 * Created by Denis on 6/13/2016
 */
@Repository
public class OperationRepositoryImpl implements OperationRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Inject
    public OperationRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void createInfoOperation(Integer id) {
        String SQL = "INSERT INTO operation " +
                "(card_id, operation_type_id, operation_time) " +
                "values (?, ?, ?)";
        jdbcTemplate.update(SQL, id, INFO.getId(), Timestamp.valueOf(now()));
    }

    @Override
    public void createWithdrawOperation(Integer id, BigDecimal amount) {
        String SQL = "INSERT INTO operation " +
                "(card_id, operation_type_id, operation_time, amount) " +
                "values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, id, WITHDRAW.getId(), Timestamp.valueOf(now()), amount);
    }
}
