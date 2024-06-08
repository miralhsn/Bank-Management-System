<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bank Management System</title>
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
            text-align: center;
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

        ul {
            list-style-type: none;
            padding: 0;
            text-align: center;
        }

        li {
            display: inline-block;
            margin: 10px;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

        .form-container {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
        }

        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            background-color: #007bff;
            border: none;
            color: #fff;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Bank Management System</h1>
    <div class="container">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/customers" class="btn">Manage Customers</a></li>
                    <li><a href="${pageContext.request.contextPath}/customers/new" class="btn">Add New Customer</a></li>
                    <li><a href="${pageContext.request.contextPath}/transactions" class="btn">Process Transactions</a></li>
                    <li><a href="${pageContext.request.contextPath}/transactions/new" class="btn">Add New Transaction</a></li>
                    <li><a href="${pageContext.request.contextPath}/reports" class="btn">Generate Financial Reports</a></li>
                    <li><a href="${pageContext.request.contextPath}/loans" class="btn">View Loans</a></li>
                    <li><a href="${pageContext.request.contextPath}/loans/new" class="btn">Submit Loan</a></li>
                    <li><a href="${pageContext.request.contextPath}/supports" class="btn">Customer Support</a></li>
                    <li><a href="${pageContext.request.contextPath}/supports/new" class="btn">Submit Support Ticket</a></li>
                    <li><a href="${pageContext.request.contextPath}/notifications" class="btn">Account Notifications</a></li>
                    <li><a href="${pageContext.request.contextPath}/notifications/new" class="btn">Add New Notification</a></li>
                    <li><a href="${pageContext.request.contextPath}/users/logout" class="btn btn-secondary">Logout</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/users/login" class="btn">Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/users/signup" class="btn">Sign Up</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>

