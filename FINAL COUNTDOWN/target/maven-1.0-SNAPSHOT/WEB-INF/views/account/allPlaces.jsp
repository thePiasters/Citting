<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 13.09.17
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>

        .wrapper {
            color:black;
            text-align: center;
            font-size: 200%;
            padding-top:10%;
        }
        #button {

            background-color: greenyellow;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            color: black;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;

        }
        body
        {
            background-image: url("/resources/style/city.jpg");
            background-size: 1500px 800px;

        }
    </style>


    <title>Account</title>

    <html>

<body>
<c:if test="${isLogged}">
<div class="container">
    <h2>Hello !</h2>
    <p><em>You are logged as ${user.login}</em><br></p>
    <ul class="nav nav-tabs" role="tablist">
        <li ><a href="http://localhost:8080/profile">Home</a></li>
        <li class="active">  <a href="http://localhost:8080/allPlaces">Show all places</a></li>
        <li>  <a href="http://localhost:8080/wishlist">Wish list</a> </li>
        <li><a href ="http://localhost:8080/user/edit/${user.id}">Account Settings</a></li>
        <li><a href="http://localhost:8080/history">Review Visited Places</a></li>
        <li> <a href="http://localhost:8080/viewRate">Manage your rates and opinions</a></li>
        <li><a href="http://localhost:8080/user/logout">Log out</a></li>
    </ul>

    </c:if>


    <div class="wrapper">

        <form 	action="/allPlaces" method="post">
            <input name="search" placeholder="Search..">
            <input type="submit">
        </form>

        <c:forEach items="${places}" var="place">
            <a href="http://localhost:8080/place/page/${place.id}"><h3>${place.name}</h3></a>
            <br>
        </c:forEach>

        <c:forEach items="${allPlaces}" var="place">
            <a href="http://localhost:8080/place/page/${place.id}">${place.name}</a>
            ${place.category.name}
            <br>
        </c:forEach>
    </div>




    <c:if test="${!isLogged}">
        You are not logged in!
        <a href="http://localhost:8080/user/signIn"><em>Sign In</em></a> or
        <a href="http://localhost:8080/user/signUp"><em> Sign Up</em></a>
    </c:if>
</div>


</body>
</html>

