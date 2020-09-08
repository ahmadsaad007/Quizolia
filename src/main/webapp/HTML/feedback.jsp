<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="link.html" %>
<html>
  <head>
      <title>Title</title>
      <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
  </head>
  <body>
  <div class = "quizContainer">
  <form method="post" action="${pageContext.request.contextPath}/feedback">
<%--${pageContext.request.contextPath}/--%>
    Enter Rating: <input class="textBox" type="text" name="rating" /><p></p>
    Enter Comments: <input class="textBox" type="text" name="text"><p></p>
    <input id="submitBtn" type="submit" value="Submit">
    <input id="submitBtn" type="reset">
  </form>
  </div>
  </body>
</html>
