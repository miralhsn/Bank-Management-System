package com.bean;

public class CustomerFinancialReport {
    private Long customerId;
    private double totalTransactionsAmount;
    private double totalLoansAmount;
    private double netAmount;

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

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
}
