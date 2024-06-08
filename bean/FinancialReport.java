package com.bean;

import java.util.List;

public class FinancialReport {
    private double totalTransactionsAmount;
    private double totalLoansAmount;
    private double netAmount;
    private List<CustomerFinancialReport> customerReports;

    // Getters and Setters
    public double getTotalTransactionsAmount() {
        return totalTransactionsAmount;
    }

    public void setTotalTransactionsAmount(double totalTransactionsAmount) {
        this.totalTransactionsAmount = totalTransactionsAmount;
    }

    public double getTotalLoansAmount() {
        return totalLoansAmount;
    }

    public void setTotalLoansAmount(double totalLoansAmount) {
        this.totalLoansAmount = totalLoansAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public List<CustomerFinancialReport> getCustomerReports() {
        return customerReports;
    }

    public void setCustomerReports(List<CustomerFinancialReport> customerReports) {
        this.customerReports = customerReports;
    }
}
