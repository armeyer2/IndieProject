<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 5/2/2018
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <h2>Your info: </h2>

    <c:forEach items="${user}" var="user">
        <tr>
            <th>ID:</th>
            <td>${user.id}</td><br />
            <th>First Name:</th>
            <td>${user.firstName}</td><br />
            <th>Last Name:</th>
            <td>${user.lastName}</td><br />
            <th>Username:</th>
            <td>${user.userName}</td><br />
        </tr>
    </c:forEach>

</div>

</body>
</html>
