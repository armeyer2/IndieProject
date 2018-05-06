<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 5/2/2018
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
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

    <link rel="stylesheet" href="css/formPage.css">
    <script src="newIndex.js" type="application/javascript"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div  id="hamburger"class="container">
        <a class="navbar-brand js-scroll-trigger" href="index.jsp">April</a>
        <img id="palmTree" src="img/palm tree navbar logo.png" alt="">

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul id="navbarLinks"class="navbar-nav ml-auto">

                <li class="nav-item">
                    <a class="nav-link " href="userManager" id="admin">Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/signUp.jsp" id="signUp">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#overlay" id="accountInfo">See Account Info</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div id="signUpOverlay">
    <div id="signUptext">
        <form action="signUp" method="POST">
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" name="firstName" class="form-control" id="firstName">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" name="lastName" class="form-control" id="lastName">
            </div>
            <div class="form-group">
                <label for="birthYear">Birth Year:</label>
                <input type="text" name="birthYear" class="form-control" id="birthYear">
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" class="form-control" id="username">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" name="pwd" class="form-control" id="pwd">
            </div>
            <div class="form-group">
                <label for="re-pwd">Repeat Password:</label>
                <input type="password" name="re-pwd" class="form-control" id="re-pwd">
            </div>
            <button type="Submit" id="signUpSubmit" value="Log In" class="btn btn-default">Submit</button>
            <button type="button" id="signUpCancel" href="/index.jsp" class="btn btn-default">Cancel</button>
        </form>
    </div>
</div>

</body>
</html>
