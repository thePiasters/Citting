<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 03.09.17
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
Categories:<br>
<tr>
    <td>
        Name:
    </td>
</tr>
<br>
<c:forEach items="${categories}" var="cat">
    <tr>
        <td>${cat.name}</td>

        <td><a href="http://localhost:8080/category/remove/${cat.id}"> Usun</a>
            <a href="http://localhost:8080/category/edit/${cat.id}"> Edytuj</a></td>

    </tr>
    <br>
</c:forEach>

</body>
</html>
