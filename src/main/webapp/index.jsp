<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 5/2/2018
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width" />
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
</head>
<body>

<div class="container-fluid">
    <div class="jumbotron" >
        <img id="jumbotronImage" src="img/winter forest png.png" alt="winter forest">
        <img id="mobileJumbotronImage" src="img/mobile winter forest.png" alt="winter forest">
        <a id="scrollButton" href="#merch" class="btn btn-circle js-scroll-trigger">
            <i class="fa fa-angle-double-down animated"></i>
        </a>
        <a id="mobileScrollButton" href="#merch" class="btn btn-circle js-scroll-trigger">
            <i class="fa fa-angle-double-down animated"></i>
        </a>
    </div>
</div>

<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div  id="hamburger"class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">April</a>
        <img id="palmTree" src="img/palm tree navbar logo.png" alt="">

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul id="navbarLinks" class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#merch">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#contact">Contact</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " href="userManager" id="admin">Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="signUp.jsp" id="signUp">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="userInfo" id="accountInfo">See Account Info</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " id="name">${firstName}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" id="signIn">Sign In</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<<<<<<< HEAD
<div class="container-fluid" id="overlay">
    <form>
    <div class="form-group">
      <label for="email">Email address:</label>
      <input type="email" class="form-control" id="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
    <button type="button" id="closeSignUp" class="btn btn-default" name="button">Close</button>
  </form>

</div>




=======
>>>>>>> RollbackBranch
<section id="merch" class="content-section">
    <div class="container-fluid">

        <div class="row">
            <div id="infoMerch" class="col-md-4">
                <div id="infoMerchText" >
                    <p id="inspirationText">This months line-up is inspired by the lush forests of Yellowstone National Park. Click to see your dynamic price</p>
                    <a id="scrollButtonProduct" href="chartPage" class="btn btn-basic js-scroll-trigger">
                        <i class="fa fa-angle-double-down animated"></i>
                    </a>
                </div>


            </div>
            <div id="doubleShirt" class="col-md-8 text-center col-xs-12">

                <img src="img/winter forest line up cartoons2.png" alt="Double Shirt">

            </div>

        </div>
    </div>
</section>

<div id="priceOverlay">
    <div id="priceOverlayText">

        <h2 id="priceText">Crewneck $23.99 - Long Sleeve $19.99</h2>
        <h2 class="phoneText">Crewneck $23.99</h2>
        <h2 class="phoneText">Long Sleeve $19.99</h2>
        <p class="paragraph">(Regular Price: Crewneck $29.99 - Long Sleeve $24.99)</p>
        <div id="info">
            <p class="paragraph">This months line-up is inspired by the lush forests of Yellowstone National Park.</p>
        </div>
        <div class="col-xs-6" id="formPurchaseArea">
            <button type="button" id="purchase" class="btn reminder" name="purchaseButton">Purchase</button>

        </div>
        <div class="col-xs-6" id="formArea">
            <button type="button" id="reminder" class="btn reminder" name="button">Reminder?</button>

        </div>
        <button type="button" id="purchaseCancel" class="btn btn-default">Cancel</button>
        <div id="social" class="row">
            <div class="col-xs-4 mx-auto">
                <ul class="list-inline banner-social-buttons">
                    <li class="list-inline-item">
                        <a href="https://twitter.com/" class="btn btn-default btn-lg">
                            <i class="fa fa-twitter fa-fw"></i>
                            <span class="network-name">Twitter</span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://plus.google.com/" class="btn btn-default btn-lg">
                            <i class="fa fa-google-plus fa-fw"></i>
                            <span class="network-name">Google+</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>




<!-- Footer -->
<footer>


    <div id="contactContainer" class="container text-center">
        <p id="contact" class="copyright"> Contact Support: frontend@gmail.com</p>
        <p class="copyright">Copyright &copy; Aaron Meyer</p>

    </div>
</footer>









<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts -->
<script src="js/newIndex.js"></script>
<script src="js/chartScript.js"></script>

</body>
</html>
