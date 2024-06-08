<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Loan List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }

        h1 {
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

        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-secondary {
            background-color: #6c757d;
        }

        .btn-secondary:hover {
            background-color: #565e64;
        }

        .btn-container {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Loan List</h1>
    <div class="container">
        <table>
            <tr>
                <th>ID</th>
                <th>Customer ID</th>
                <th>Amount</th>
                <th>Interest Rate</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="loan" items="${loans}">
                <tr>
                    <td>${loan.id}</td>
                    <td>${loan.customerId}</td>
                    <td>${loan.amount}</td>
                    <td>${loan.interestRate}</td>
                    <td>${loan.startDate}</td>
                    <td>${loan.endDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/loans/edit/${loan.id}" class="btn">Edit</a>
                        <a href="${pageContext.request.contextPath}/loans/delete/${loan.id}" class="btn btn-secondary">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="btn-container">
            <a href="${pageContext.request.contextPath}/loans/new" class="btn">Add New Loan</a>
        </div>
    </div>
</body>
</html>
