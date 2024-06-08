<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notification Form</title>
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

        .form-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-container div {
            margin: 10px 0;
        }

        .form-container label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-container input[type="text"],
        .form-container input[type="date"] {
            width: 100%;
            padding: 10px;
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
    <h1>Notification Form</h1>
    <div class="form-container">
        <c:set var="formAction" value="${notification.id == null ? '/notifications/save' : '/notifications/update'}"/>
        <form:form action="${pageContext.request.contextPath}${formAction}" method="post" modelAttribute="notification">
            <form:hidden path="id"/>
            <div>
                <label for="customerId">Customer ID:</label>
                <form:input path="customerId" id="customerId"/>
            </div>
            <div>
                <label for="message">Message:</label>
                <form:input path="message" id="message"/>
            </div>
            <div>
                <label for="dateCreated">Date Created:</label>
                <form:input path="dateCreated" id="dateCreated" type="date"/>
            </div>
            <div>
                <label for="status">Status:</label>
                <form:input path="status" id="status"/>
            </div>
            <div>
                <input type="submit" value="Save"/>
            </div>
        </form:form>
        <div class="btn-container">
            <a href="${pageContext.request.contextPath}/notifications" class="btn">Back to Notification List</a>
        </div>
    </div>
</body>
</html>
