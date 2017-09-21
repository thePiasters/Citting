<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 04.09.17
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Citting</title>
    <style>
        .wrapper {
            background-size: 40px 60px;
            text-align: center;
            color: black;
            padding-top: 5%;
            font-size: 150%;
        }
        body{
            background-image: url("/resources/style/categories1.jpg");
            background-size: 1500px 700px;
            background-repeat: no-repeat;
        }
    </style>
    <script>

        if(sessionStorage.getItem("login"))
        {
            document.getElementById("log").style.display="none";
        }
    </script>
</head>
<body>
<div class="wrapper">
    <strong>
        <div id="log">

            <c:if test="${!isLogged}">
                <a href="http://localhost:8080/user/signIn"><em>Sign In</em></a> or <a href="http://localhost:8080/user/signUp"><em> Sign Up</em></a>
            </c:if>

        </div>
    <h2>Choose category:</h2>


                <form method="post">

                <c:forEach items="${categories}" var="cat">

                    <input type="checkbox" name="categories" value=${cat.id}>${cat.name}
                    <br>
                </c:forEach>

                    <input type="submit" value="Save">
                </form>
    </strong>
</div>
</body>
</html>
