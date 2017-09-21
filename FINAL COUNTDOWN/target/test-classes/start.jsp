<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 06.09.17
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .wrapper {
            text-align: center;
        }

        #button {
            position: absolute;
            top: 40%;
            background-color: #4CAF50; /* Green */
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            text-align: center;
            left: 580px;

        }
        body {
            background-image: url("/resources/style/city.jpg");
        }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded" , function () {



            var start = document.getElementById('button');


            start.addEventListener('click',function (event)
            {
                event.preventDefault();
                sessionStorage.setItem("login",false);
                window.location = "http://localhost:8080/home";


            });


        });
    </script>
    <title>Start</title>
</head>
<body>
<div class="wrapper">
    <div id="login">

    <c:if test="${!isLogged}">
        <a href="http://localhost:8080/user/signIn"><em>Sign In</em></a> or <a href="http://localhost:8080/user/signUp"><em> Sign Up</em></a>
    </c:if>
        <h1><em>If you have tacos I will find them...</em></h1>

    <h1><em>and I will eat them</em></h1>
    <button type="submit" class=".center-block" id="button">Start Citting</button>
    </div>

</div>





</body>
</html>
