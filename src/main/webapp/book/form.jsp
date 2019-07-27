<%@ page import="com.j21.bookstore.model.BookType" %>
<%@ page import="com.j21.bookstore.model.Book" %>
<%@ page import="com.j21.bookstore.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.j21.bookstore.model.Publisher" %><%--
  Created by IntelliJ IDEA.
  User: amen
  Date: 7/27/19
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<%-- Formularz dodawania ksiazki. --%>
<form action="/book/add" method="post">
    Title:<input type="text" name="title"><br>
    Year published:<input type="number" name="yearPublished" min="1900" max="2100"><br>
    Pages:<input type="number" name="pages" min="1" max="1000"><br>
    Book type:
    <select name="bookType">
        <%
            for (BookType bookType : BookType.values()) {
                out.print("<option value=\"" + bookType.name() + "\" >" + bookType.name() + "</option>");
            }
        %>
    </select>
    Author:
    <select name="authorId">
        <%
            List<Author> authors = (List<Author>) request.getAttribute("authors");
            for (Author author : authors) {
                out.print("<option value=\"" + author.getId() + "\" >" + author.getName() + " " + author.getSurname() + "</option>");
            }
        %>
    </select>
    Publisher:
    <select name="publisherId">
        <%
            List<Publisher> publishers = (List<Publisher>) request.getAttribute("publishers");
            for (Publisher publisher : publishers) {
                out.print("<option value=\"" + publisher.getId() + "\" >" + publisher.getName() + "</option>");
            }
        %>
    </select>
    <br>
    <input type="submit">
</form>

</body>
</html>
