<%@ include file="link.html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Title</title>
      <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
  </head>
  <body>
  <div class = "container">
  <form method="post" action="${pageContext.request.contextPath}/feedback">
<%--${pageContext.request.contextPath}/--%>
    Enter Rating: <input type="text" name="rating" /><p></p>
    Enter Comments: <input type="text" name="text"><p></p>
    <input type="submit" value="Submit">
    <input type="reset">
  </form>
  </div>
  </body>
</html>
