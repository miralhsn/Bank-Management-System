package com.dao;

import com.bean.CustomerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerSupportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CustomerSupport> findAll() {
        String sql = "SELECT * FROM support_tickets";
        return jdbcTemplate.query(sql, new CustomerSupportRowMapper());
    }

    public CustomerSupport findById(Long id) {
        String sql = "SELECT * FROM support_tickets WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerSupportRowMapper());
    }

    public void save(CustomerSupport support) {
        String sql = "INSERT INTO support_tickets (customerId, issue, dateCreated, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, support.getCustomerId(), support.getIssue(), support.getDateCreated(), support.getStatus());
    }

    public void update(CustomerSupport support) {
        String sql = "UPDATE support_tickets SET customerId = ?, issue = ?, dateCreated = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql, support.getCustomerId(), support.getIssue(), support.getDateCreated(), support.getStatus(), support.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM support_tickets WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class CustomerSupportRowMapper implements RowMapper<CustomerSupport> {
        @Override
        public CustomerSupport mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerSupport support = new CustomerSupport();
            support.setId(rs.getLong("id"));
            support.setCustomerId(rs.getLong("customerId"));
            support.setIssue(rs.getString("issue"));
            support.setDateCreated(rs.getDate("dateCreated"));
            support.setStatus(rs.getString("status"));
            return support;
        }
    }
}
