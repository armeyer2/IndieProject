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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Front-End</title>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="css/newIndex.css" rel="stylesheet">
    <link rel="stylesheet" href="css/formPage.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div  id="hamburger"class="container">
        <a class="navbar-brand js-scroll-trigger" href="indexServlet">April</a>
        <img id="palmTree" src="img/palm tree navbar logo.png" alt="">

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul id="navbarLinks"class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link " href="signUp.jsp" id="signUp">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="signIn" id="signIn">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="logoutUser" id="logout">Logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="userInfo" id="accountInfo">See Account Info</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " id="name">${firstName}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="userManager" id="admin">${adminPage}</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div id="users" class="col-xs-6">
            <h2>All users: </h2>
            <table id="userTable">
                <thead>
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Username</td>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>
                            <form action="deleteUser" method="post">
                                <input type="hidden" name="userId" value="${user.id}" />
                                <input type="submit" value="Remove" name="remove">
                            </form>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="orders" class="col-xs-6">
            <h2>All orders: </h2>

            <c:forEach items="${orders}" var="order">
                <tr>
                    <th>ID:</th>
                    <td>${order.id}</td><br />
                    <th>First Name:</th>
                    <td>${order.description}</td><br />

                </tr>
            </c:forEach>
        </div>
    </div>

</div>

</body>
</html>
