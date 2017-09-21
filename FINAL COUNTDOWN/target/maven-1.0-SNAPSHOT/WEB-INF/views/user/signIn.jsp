<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 04.09.17
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <style>

        body {
            background-image: url("/account/form.jpg");
            background-size: 1400px 800px;
            background-repeat: no-repeat;
            background-position: 50%
        }

        .wrapper {

            color:black;
            text-align: center;
            width: 220px;
            height: 250px;
            padding-top: 10%;
            padding-left:40%;

        }

    </style>
</head>
<body>
<div class="wrapper">
    <h1>Sign In</h1>

    <form method="post">
        Login:
        <br>
        <input name="login" placeholder="email or login"/>
        <br>
        Password:
        <input type="password" name="password"/>
        <br>
        <input type="submit" value="Sign In"/>
    </form>
    <a href="http://localhost:8080/user/passwordReminder">I forgot my password</a><br>
    <a href="http://localhost:8080/user/signUp">I do not have an account yet</a>
</div>


</body>
</html>
