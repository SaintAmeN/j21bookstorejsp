<%--
  Created by IntelliJ IDEA.
  User: amen
  Date: 7/27/19
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author form</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<%-- Formularz dodawania studenta. --%>
<form action="/author/add" method="post">
    Name:<input type="text" name="name"><br>
    Surname:<input type="text" name="surname"><br>
    Year of birth:<input type="number" name="yob" min="1" max="100"><br>
    Place of birth:<input type="text" name="pob"><br>
    <input type="submit">
</form>

</body>
</html>
