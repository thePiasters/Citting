<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 28.08.17
  Time: 00:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Citting</title>
<head>

    <link href="<c:url value="${pageContext.request.contextPath}/resources/style/style.css" />" rel="stylesheet">

</head>
<body>

<div id="drink">
    Beer
</div>
<div id="snack">
    FOOD
</div>


<div class="snackers">
    FOOOOOOOOOD !!!!
    <form class="snackers">

        <input id='w' type="checkbox">Italian cusine <br>
        <input id='ch 'type="checkbox">Chiniese food <br>
        <input id='confirm_food' type="submit" value="confirm">
    </form>

</div>

<div class="drinkers">
    BEEEEEEEEEEEEEEEEEEEEEEEEEERR!
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<script src="<c:url value="/resources/js/JavaScript.js" />"></script>
</body>
</html>
<body>

</body>
</html>

