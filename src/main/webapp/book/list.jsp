<%@ page import="com.j21.bookstore.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.j21.bookstore.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: amen
  Date: 7/27/19
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<a href="/book/add">Add new Book</a>

<%! // z wykrzyknikiem deklarujemy metody lub zmienne

    public String generateRemoveLink(Book a) {
        return "<a href=\"/book/remove?id=" + a.getId() + "\">Remove</a>";
    }
%>

<table>
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Pages</th>
        <th>Type</th>
        <th></th>
    </tr>
    <%
        List<Book> items = (List<Book>) request.getAttribute("items");
        for (Book a : items) {
            out.print("<tr>");
            out.print("<td>" + a.getTitle() + "</td>");
            out.print("<td>" + a.getYearPublished() + "</td>");
            out.print("<td>" + a.getPages() + "</td>");
            out.print("<td>" + a.getBookType() + "</td>");
            out.print("<td>" + generateRemoveLink(a) + "</td>");
            out.print("</tr>");
        }
    %>
</table>

</body>
</html>
