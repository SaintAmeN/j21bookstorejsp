<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.j21.bookstore.model.Author" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: amen
  Date: 7/27/19
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Author list</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Year of birth.</th>
        <th>Place of birth</th>
    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td><c:out value="${item.getName()}"/> </td>
            <td><c:out value="${item.getSurname()}"/> </td>
            <td><c:out value="${item.getYearOfBirth()}"/> </td>
            <td><c:out value="${item.getPlaceOfBirth()}"/> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
