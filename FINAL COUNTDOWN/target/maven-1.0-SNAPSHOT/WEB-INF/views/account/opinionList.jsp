<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 17.09.17
  Time: 02:02
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
        table {
            border: 1px solid black;
            padding: 10px 15px;
        }
        tr, td {
            border: 1px solid black;
            padding: 10px 15px;
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
            <li>  <a href="http://localhost:8080/allPlaces">Show all places</a></li>
            <li>  <a href="http://localhost:8080/wishlist">Wish list</a> </li>
            <li><a href ="http://localhost:8080/user/edit/${user.id}">Account Settings</a></li>
            <li ><a href="http://localhost:8080/history">Review Visited Places</a></li>
            <li class="active"> <a href="http://localhost:8080/viewRate">Manage your rates and opinions</a></li>
            <li ><a href="http://localhost:8080/user/logout">Log out</a></li>
        </ul>

        </c:if>

        <div class="wrapper">




                    <table>
                    <tr>
                    <td>
                    Name:
                    </td>
                    <td>
                    Your rate:
                    </td>
                    <td>
                    Your opinion:
                    </td>
                    <td>
                    In history:

                    </td>
                    <td>
                    On wish list:
                    </td>
                    <td>
                    Modify:
                    </td>


                    </tr>

                    <c:forEach items="${userPlace}" var="userPlace">

                        <tr>
                            <td> ${userPlace.place.name}</td>

                            <c:if test="${userPlace.rate!=0}">
                                <td>    ${userPlace.rate}</td>
                            </c:if>

                            <c:if test="${userPlace.rate==0}">
                                <td> </td>
                            </c:if>

                            <c:if test="${not empty userPlace.opinion}">
                                <td>text ${userPlace.opinion}    </td>
                            </c:if>

                            <c:if test="${empty userPlace.opinion}">
                                <td></td>
                            </c:if>
                            <td>${userPlace.history}</td>
                            <td>${userPlace.wishList}</td>
                            <td>
                                <a href="http://localhost:8080/rate/${userPlace.id}"> edit</a>

                                <a href="http://localhost:8080/removeOpinion/${userPlace.id}">remove</a></td>

                        </tr>
                        <br>
                    </c:forEach>
                    </table>

        </div>




                <c:if test="${!isLogged}">
                    You are not logged in!
                    <a href="http://localhost:8080/user/signIn"><em>Sign In</em></a> or
                    <a href="http://localhost:8080/user/signUp"><em> Sign Up</em></a>
                </c:if>
    </div>


    </body>
</html>

