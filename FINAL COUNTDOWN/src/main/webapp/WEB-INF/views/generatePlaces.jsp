<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 04.09.17
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generate Places</title>
    <style>
        .wrapper {
            text-align: center;
            font-size: 150%;
            padding-top: 5%;
        }
        body{
            background-image: url("/resources/style/city1.jpg");
            background-size: 1500px 800px;
            background-repeat: no-repeat;
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="wrapper">

    <img src="${pageContext.request.contextPath}style/form.jpg" alt="">
    <img src="form.jpg">
    <h1>Found places:</h1><br>
    <c:forEach items="${listPlace}" var="place">

           <a href="http://localhost:8080/place/page/${place.id}">${place.name}</a>
            <br>

    </c:forEach>



</div>


</body>
</html>
