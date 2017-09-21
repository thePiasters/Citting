<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 14.09.17
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
        <body>

            <%--@elvariable id="userPlace" type="UserPlace"--%>
            <form:form method="post" modelAttribute="userPlace">

                <br>
                Write an opinion:<br>
                <form:input path="opinion" type="textera"/><br>
                Rate:
                <form:input path="rate"/>


                <input type ="submit" value="rate">
            </form:form>



        </body>
</html>