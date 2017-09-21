<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 05.09.17
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body{
        background-image: url("/account/form.jpg");
    }
</style>
<head>
    <title>Password reminder</title>
    <style>
        .wrapper {
            text-align: center;
            font-size: 200%;
            padding-top:10%;
        }
    </style>

</head>
<body>
    <div class="wrapper">
        <form method="post">
            Login:
            <input name="login" placeholder="login"/>
            <br>
            Email:
            <input  name="email" placeholder="email"/>
            <br>
            <input type="submit" id="reminder" value="Remind me"/>
        </form>
    </div>




</body>
</html>
