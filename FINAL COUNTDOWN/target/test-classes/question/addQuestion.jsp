<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 05.09.17
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>AddQuestion</title>
</head>
<body>
<h1>Add Question</h1>

<%--@elvariable id="question" type="com.citting.entity.Question"--%>
<form:form method="post" modelAttribute="question">

    Content:
    <form:input path="content" />
    <input type="submit" value="Save">

</form:form>


</body>
</html>
