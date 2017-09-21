<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 04.09.17
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>
    <style>
        table {
            border: 1px solid black;
            padding: 10px 15px;
        }
        tr, td {
            border: 1px solid black;
            padding: 10px 15px;
        }

    </style>
</head>
<body>

    <table>

        <td>
            First Name:
        </td>
        <td>
            Last Name:
        </td>
        <td>
            Login:
        </td>
        <td>
            E-mail:
        </td>
        <td>
            Password:
        </td>
        <td>
            Question:
        </td>
        <td>
            Answear:
        </td>
        <td>
            Change:
        </td>


        <br>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.question.content}</td>
                <td>${user.answear}</td>
                <td><a href="http://localhost:8080/user/remove/${user.id}"> Usun</a>
                    <a href="http://localhost:8080/user/edit/${user.id}"> Edytuj</a></td>

            </tr>
            <br>
        </c:forEach>

    </table>

</body>
</html>
