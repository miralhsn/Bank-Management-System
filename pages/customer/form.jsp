<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Form</title>
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
        .form-container input[type="email"] {
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
    <h1>Customer Form</h1>
    <div class="form-container">
        <form:form action="${pageContext.request.contextPath}/customers/${customer.id == null ? 'save' : 'update'}" method="post" modelAttribute="customer">
            <form:hidden path="id"/>
            <div>
                <label for="name">Name:</label>
                <form:input path="name" id="name"/>
            </div>
            <div>
                <label for="address">Address:</label>
                <form:input path="address" id="address"/>
            </div>
            <div>
                <label for="email">Email:</label>
                <form:input path="email" id="email"/>
            </div>
            <div>
                <label for="phone">Phone:</label>
                <form:input path="phone" id="phone"/>
            </div>
            <div>
                <input type="submit" value="Save"/>
            </div>
        </form:form>
        <div class="btn-container">
            <a href="${pageContext.request.contextPath}/customers" class="btn">Back to Customer List</a>
        </div>
    </div>
</body>
</html>
