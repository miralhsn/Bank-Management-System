package com.dao;

import com.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    public Customer findById(Long id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerRowMapper());
    }

    public void save(Customer customer) {
        String sql = "INSERT INTO customers (name, address, email, phone) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPhone());
    }

    public void update(Customer customer) {
        String sql = "UPDATE customers SET name = ?, address = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPhone(), customer.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setEmail(rs.getString("email"));
            customer.setPhone(rs.getString("phone"));
            return customer;
        }
    }
}
