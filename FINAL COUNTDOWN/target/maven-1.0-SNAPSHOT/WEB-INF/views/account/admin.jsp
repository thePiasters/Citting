<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 07.09.17
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .wrapper
        {
            text-align:center;
            padding-top: 5%;
            font-size: 200%;
        }
        body
        {
            background-image: url("/account/form.jpg");
        }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded" , function () {
            var logout = document.getElementById("button");

            logout.addEventListener('click', function (event) {

                event.preventDefault();

                window.location = 'http://localhost:8080/user/logout';


            });
        });

    </script>
</head>
        <body>
            <c:if test="${loggedAsAdmin}">

                <div class="wrapper">
                        <a href="http://localhost:8080/place/list">Manage Places</a><br>
                        <a href="http://localhost:8080/place/add">Add Places</a><br>

                        <a href="http://localhost:8080/user/list">Manage Users</a><br>
                        <a href="http://localhost:8080/category/list">Manage Categories</a><br>

                        <a href="http://localhost:8080/category/add">Add Category</a><br>

                        <a href="http://localhost:8080/question/add"> Add Forgot Password Question</a><br>
                        <a href="http://localhost:8080/question/list"> Manage Forgot Password Questions</a><br>
                        <input type="submit" id="button" value="log out">
                </div>
            </c:if>
            <c:if test="${!loggedAsAdmin}">
                You do not have an access to this page
            </c:if>

        </body>
</html>