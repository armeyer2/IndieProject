<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 5/4/2018
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <td>id</td>
            <td>Name</td>
            <td>Username</td>
        </tr>
        </thead>

        <tbody>
        <c:foreach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.username}"/></td>
            </tr>
        </c:foreach>
        </tbody>
    </table>

</body>
</html>
