<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>


<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <scipt src="js/validation"></scipt>
    <script type="text/javascript">
        window.onload = function() {

            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2",
                title: {
                    text: "Your Dynamic Price"
                },
                axisX: {
                    title: "Month"
                },
                axisY: {
                    title: "Price"
                },
                data: [{
                    type: "line",
                    yValueFormatString: "#,$##0 ",
                    dataPoints : ${dataPoints}
                }]
            });
            chart.render();

        }
    </script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>

<div class="container-fluid">
    <div id="signUpOverlay">
        <div id="signUptext">
            Your Price: $${price}.00
            <form action="/orderPage" method="POST" name="orderForm">
                <select name="itemType">
                    <option value="May long sleeve">May Long Sleeve</option>
                    <optgroup value="May short sleeve">May Short Sleeve</optgroup>
                </select>
                <select name="amount">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <br><br>
                <label for="address">Address: </label>
                <input type="text" name="address" id="address">
                <label for="city">City: </label>
                <input type="text" name="city" id="city">
                <label for="state">State: </label>
                <input type="text" name="state" id="state">
                <input type="submit">
            </form>
        </div>
    </div>
</div>


<p>${confirmation}</p>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>