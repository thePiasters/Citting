<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 04.09.17
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
            <li>  <a href="http://localhost:8080/allPlaces">Show all places</a></li>
            <li>  <a href="http://localhost:8080/wishlist">Wish list</a> </li>
            <li class="active"><a href ="http://localhost:8080/user/edit/${user.id}">Account Settings</a></li>
            <li ><a href="http://localhost:8080/history">Review Visited Places</a></li>
            <li> <a href="http://localhost:8080/viewRate">Manage your rates and opinions</a></li>
            <li><a href="http://localhost:8080/user/logout">Log out</a></li>
        </ul>
    </div>
    </c:if>

    <div class="wrapper">

            <c:if test="${!isLogged}">
                <h1>Sign Up</h1>
            </c:if>
            <c:if test="${isLogged}">
                <h1> Settings</h1>
            </c:if>


            <%--@elvariable id="user" type="User"--%>
            <form:form method="post" modelAttribute="user">

                Login:
                <br>
                <form:errors path="login" cssClass="error"/>
                <form:input path="login" />
                <br>
                FirstName:
                <br>
                <form:input path="firstName" />
                <br>
                LastName:
                <form:input path="lastName" />
                <br>
                password:
                <form:password path="password" />
                <br>
                E-mail:
                <br>
                <form:input path="email"/>
                <br>
                Choose question:
                <br>
                <form:select path="question" items="${questions}" itemValue="id" itemLabel="content" multiple="false"/>
                <br>
                Write an answear:
                <br>
                <form:input path="answear" />
                <br>



                <c:if test="${!isLogged}">
                    <input type="submit" value="Sign Up">
                </c:if>

                <c:if test="${isLogged}">
                    <input type="submit" value="Save">
                </c:if>

            </form:form>

    </div>




    <c:if test="${!isLogged}">
        You are not logged in!
        <a href="http://localhost:8080/user/signIn"><em>Sign In</em></a> or
        <a href="http://localhost:8080/user/signUp"><em> Sign Up</em></a>
    </c:if>
</div>


</body>
</html>
