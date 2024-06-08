package com.dao;

import com.bean.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TransactionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Transaction> findAll() {
        String sql = "SELECT * FROM transactions";
        return jdbcTemplate.query(sql, new TransactionRowMapper());
    }

    public Transaction findById(Long id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TransactionRowMapper());
    }

    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions (accountId, date, type, amount) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, transaction.getAccountId(), transaction.getDate(), transaction.getType(), transaction.getAmount());
    }

    public void update(Transaction transaction) {
        String sql = "UPDATE transactions SET accountId = ?, date = ?, type = ?, amount = ? WHERE id = ?";
        jdbcTemplate.update(sql, transaction.getAccountId(), transaction.getDate(), transaction.getType(), transaction.getAmount(), transaction.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class TransactionRowMapper implements RowMapper<Transaction> {
        @Override
        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transaction transaction = new Transaction();
            transaction.setId(rs.getLong("id"));
            transaction.setAccountId(rs.getLong("accountId"));
            transaction.setDate(rs.getDate("date"));
            transaction.setType(rs.getString("type"));
            transaction.setAmount(rs.getBigDecimal("amount"));
            return transaction;
        }
    }
}
