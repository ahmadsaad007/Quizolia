<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="link.html" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>logout</title>
    <link rel="stylesheet" href="../CSS/logoutStyle.css">
</head>
<body>
<div class="container">
<form method="get" action="${pageContext.request.contextPath}/logout">
    <div class="logoutDiv">
        <p>Do you wish to Logout?</p>
        <input class="yesBtn" type="submit" value="Yes" name="Yes">
        <input class ="noBtn" type="submit" value="No" name="No">
    </div>
</form>
</div>
</body>
</html>