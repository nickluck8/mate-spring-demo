<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nikol
  Date: 1/28/2018
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

</head>
<body>
<div class="container mt-5">
    <c:forEach var="c" items="${category}">
        <a href="<c:url value="/category/get/${cId}"/> "><h1>${c.name}</h1></a>
    </c:forEach>
</div>
</body>
</html>
