package com.dao;

import com.bean.CustomerFinancialReport;
import com.bean.FinancialReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FinancialReportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FinancialReport generateReport() {
        String transactionQuery = "SELECT SUM(amount) FROM transactions";
        String loanQuery = "SELECT SUM(amount) FROM loans";

        double totalTransactionsAmount = jdbcTemplate.queryForObject(transactionQuery, Double.class);
        double totalLoansAmount = jdbcTemplate.queryForObject(loanQuery, Double.class);

        FinancialReport report = new FinancialReport();
        report.setTotalTransactionsAmount(totalTransactionsAmount);
        report.setTotalLoansAmount(totalLoansAmount);
        report.setNetAmount(totalTransactionsAmount - totalLoansAmount);

        List<CustomerFinancialReport> customerReports = generateCustomerReports();
        report.setCustomerReports(customerReports);

        return report;
    }

    private List<CustomerFinancialReport> generateCustomerReports() {
        String customerReportQuery = "SELECT c.id as customerId, " +
                "COALESCE(SUM(t.amount), 0) as totalTransactionsAmount, " +
                "COALESCE(SUM(l.amount), 0) as totalLoansAmount " +
                "FROM customers c " +
                "LEFT JOIN transactions t ON c.id = t.accountId " +
                "LEFT JOIN loans l ON c.id = l.customerId " +
                "GROUP BY c.id";

        return jdbcTemplate.query(customerReportQuery, new CustomerFinancialReportRowMapper());
    }

    private static final class CustomerFinancialReportRowMapper implements RowMapper<CustomerFinancialReport> {
        @Override
        public CustomerFinancialReport mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerFinancialReport report = new CustomerFinancialReport();
            report.setCustomerId(rs.getLong("customerId"));
            report.setTotalTransactionsAmount(rs.getDouble("totalTransactionsAmount"));
            report.setTotalLoansAmount(rs.getDouble("totalLoansAmount"));
            report.setNetAmount(rs.getDouble("totalTransactionsAmount") - rs.getDouble("totalLoansAmount"));
            return report;
        }
    }
}
