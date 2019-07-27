<%@ page import="com.j21.bookstore.model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: amen
  Date: 7/27/19
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author list</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<a href="/author/add">Add new Author</a>

<%! // z wykrzyknikiem deklarujemy metody lub zmienne

    public String generateRemoveLink(Author a) {
        return "<a href=\"/author/remove?id=" + a.getId() + "\">Remove</a>";
    }
%>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Year of birth.</th>
        <th>Place of birth</th>
        <th></th>
    </tr>
    <%
        List<Author> items = (List<Author>) request.getAttribute("items");
        for (Author a : items) {
            out.print("<tr>");
            out.print("<td>" + a.getName() + "</td>");
            out.print("<td>" + a.getSurname() + "</td>");
            out.print("<td>" + a.getYearOfBirth() + "</td>");
            out.print("<td>" + a.getPlaceOfBirth() + "</td>");
            out.print("<td>" + generateRemoveLink(a) + "</td>");
            out.print("</tr>");
        }
    %>
</table>

</body>
</html>
