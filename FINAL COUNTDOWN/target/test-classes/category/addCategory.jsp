<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 01.09.17
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <h1>Add Category</h1>
    <%--@elvariable id="category" type="Category"--%>
    <form:form method="post" modelAttribute="category">
        Name:
        <form:input path="name" />
        <input type="submit" value="Save">
    </form:form>

</head>
<body>

</body>
</html>
