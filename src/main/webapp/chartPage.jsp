<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

    map = new HashMap<Object,Object>(); map.put("label", "November"); map.put("y", 188); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "December"); map.put("y", 213); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "January"); map.put("y", 213); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "February"); map.put("y", 219); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "March"); map.put("y", 207); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "April"); map.put("y", 167); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "May"); map.put("y", 136); list.add(map);

    String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>