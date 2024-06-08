<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Support Tickets</title>
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

        .table-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
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

        .btn-container {
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
    </style>
</head>
<body>
    <h1>Support Tickets</h1>
    <div class="table-container">
        <table>
            <tr>
                <th>ID</th>
                <th>Customer ID</th>
                <th>Issue</th>
                <th>Date Created</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="support" items="${supports}">
                <tr>
                    <td>${support.id}</td>
                    <td>${support.customerId}</td>
                    <td>${support.issue}</td>
                    <td>${support.dateCreated}</td>
                    <td>${support.status}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/supports/edit/${support.id}" class="btn">Edit</a>
                        <a href="${pageContext.request.contextPath}/supports/delete/${support.id}" class="btn">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="btn-container">
            <a href="${pageContext.request.contextPath}/supports/new" class="btn">Add New Ticket</a>
        </div>
    </div>
</body>
</html>
