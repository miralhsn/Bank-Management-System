<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Financial Report</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }

        h1, h2 {
            text-align: center;
            padding: 20px;
            background-color: #333;
            color: #fff;
            margin: 0;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
    <h1>Financial Report</h1>
    <div class="container">
        <table>
            <tr>
                <th>Total Transactions Amount</th>
                <td>${report.totalTransactionsAmount}</td>
            </tr>
            <tr>
                <th>Total Loans Amount</th>
                <td>${report.totalLoansAmount}</td>
            </tr>
            <tr>
                <th>Net Amount</th>
                <td>${report.netAmount}</td>
            </tr>
        </table>
        <h2>Customer Specific Reports</h2>
        <table>
            <tr>
                <th>Customer ID</th>
                <th>Total Transactions Amount</th>
                <th>Total Loans Amount</th>
                <th>Net Amount</th>
            </tr>
            <c:forEach var="customerReport" items="${report.customerReports}">
                <tr>
                    <td>${customerReport.customerId}</td>
                    <td>${customerReport.totalTransactionsAmount}</td>
                    <td>${customerReport.totalLoansAmount}</td>
                    <td>${customerReport.netAmount}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
