<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="link.html" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
</head>
<body>
<%
    session = request.getSession(false);

    if(session == null || session.getAttribute("username")==null){
        out.print("<div style='margin-top: 50px; color: crimson;'>Please login first</div>");
        request.getRequestDispatcher("login.html").include(request, response);
    }
%>
<div class="containerHome">
<a href="${pageContext.request.contextPath}/quizServlet?method=doGet&action=java"
   style="background-color: #ADD8E6; margin: 10px; width: 200px; height: 200px; border: 1px solid black; float: left; position: relative;">
    <div style="position: absolute;top: 50%; left: 50%; transform: translate(-50%, -50%);">
        JAVA
    </div>
</a>
<a href="${pageContext.request.contextPath}/quizServlet?method=doGet&action=math"
   style="background-color: #ADD8E6; margin: 10px; width: 200px; height: 200px; border: 1px solid black; float: left; position: relative;">
    <div style="position: absolute;top: 50%; left: 50%; transform: translate(-50%, -50%);">
        MATH
    </div>
</a>
<a href="${pageContext.request.contextPath}/quizServlet?method=doGet&action=science"
   style="background-color: #ADD8E6; margin: 10px; width: 200px; height: 200px; border: 1px solid black; float: left; position: relative;">
    <div style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);">
        SCIENCE
    </div>
</a>
</div>
</body>
</html>