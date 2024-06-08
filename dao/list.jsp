<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Support List</title>
</head>
<body>
    <h1>Support List</h1>
    <table border="1">
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
                    <a href="${pageContext.request.contextPath}/supports/edit/${support.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/supports/delete/${support.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/supports/new">Add New Support</a>
</body>
</html>
