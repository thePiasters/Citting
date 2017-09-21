<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 03.09.17
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <style>
    .wrapper
    {
    text-align:center;
    padding-top: 5%;
    font-size: 200%;
    }
    </style>

</head>
<body>

<div class="wrapper">
    <h1>Add Place</h1>
    <%--@elvariable id="place" type="Place"--%>
    <form:form method="post" modelAttribute="place">

        Name:
        <form:input path="name" />

        Address:
        <form:input path="address" />

        Rating:
        <form:input path="rate" />

        Description:
        <form:textarea path="description" />


        Categories:
        <form:select path="category" items="${categories}" itemValue="id" itemLabel="name" multiple="true"/>



        <input type="submit" value="Save">
    </form:form>
</div>
</body>
</html>
