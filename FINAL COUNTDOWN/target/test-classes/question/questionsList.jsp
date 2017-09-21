<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 05.09.17
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table>
    <tr>
        <td>Content</td>
        <td>Change</td>
    </tr>

<c:forEach items="${questions}" var="q">
    <tr>
        <td>${q.content}</td>
        <td><a href="http://localhost:8080/question/remove/${q.id}"> Usun</a>
            <a href="http://localhost:8080/question/edit/${q.id}"> Edytuj</a></td>
    </tr>
</c:forEach>
</table>

</body>
</html>
