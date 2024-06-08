package com.dao;

import com.bean.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LoanDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Loan> findAll() {
        String sql = "SELECT * FROM loans";
        return jdbcTemplate.query(sql, new LoanRowMapper());
    }

    public Loan findById(Long id) {
        String sql = "SELECT * FROM loans WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new LoanRowMapper());
    }

    public void save(Loan loan) {
        String sql = "INSERT INTO loans (customerId, amount, interestRate, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, loan.getCustomerId(), loan.getAmount(), loan.getInterestRate(), loan.getStartDate(), loan.getEndDate());
    }

    public void update(Loan loan) {
        String sql = "UPDATE loans SET customerId = ?, amount = ?, interestRate = ?, startDate = ?, endDate = ? WHERE id = ?";
        jdbcTemplate.update(sql, loan.getCustomerId(), loan.getAmount(), loan.getInterestRate(), loan.getStartDate(), loan.getEndDate(), loan.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM loans WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class LoanRowMapper implements RowMapper<Loan> {
        @Override
        public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loan loan = new Loan();
            loan.setId(rs.getLong("id"));
            loan.setCustomerId(rs.getLong("customerId"));
            loan.setAmount(rs.getBigDecimal("amount"));
            loan.setInterestRate(rs.getBigDecimal("interestRate"));
            loan.setStartDate(rs.getDate("startDate"));
            loan.setEndDate(rs.getDate("endDate"));
            return loan;
        }
    }
}
