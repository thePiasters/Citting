<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 03.09.17
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Places</title>
    <style>
        body{
            background-image: url("/account/form.jpg");
        }
        table {
            border: 1px solid black;
            padding: 10px 15px;
        }
        tr, td {
            border: 1px solid black;
            padding: 10px 15px;
        }
        .wrapper
        {
            text-align: center;
        }

    </style>
</head>
<body>

<div class="wrapper">
<h1>Places:</h1>
<table>
<tr>
    <td>
        Name:
    </td>
    <td>
        Addres:
    </td>
    <td>
        Description:
    </td>
    <td>
        Raiting:
    </td>
    <td>
        Categories:
    </td>
    <td>
        Changes:
    </td>
</tr>

<br>

<c:forEach items="${places}" var="place">
    <tr>
        <td>${place.name}</td>
        <td>${place.address}</td>
        <td>${place.description}</td>
        <td>${place.rate}</td>
        <td>${place.category.name} </td>



        <td><a href="http://localhost:8080/place/remove/${place.id}"> Usun</a>
            <a href="http://localhost:8080/place/edit/${place.id}"> Edytuj</a></td>

    </tr>
    <br>
</c:forEach>
</table>
</div>
</body>
</html>
