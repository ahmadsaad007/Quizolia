<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="adminLinks.html" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
  </head>
  <body>
    <div class="container">
    <table class="table">
      <tr id="heading">
        <th>ID</th>
        <th>Rating</th>
        <th>Comments</th>
      </tr>
    <%
      List feedbacks = (List) session.getAttribute("feedbacks");
      int i = 0;
      while (i<feedbacks.size()){
        Object[] array = (Object[]) feedbacks.get(i);
        int feedbackId = (int) array[0];
        int rating = (int) array[1];
        String text = (String)array[2];
    %>
      <tr>
        <td><%=feedbackId%></td>
        <td><%=rating%></td>
        <td><%=text%></td>
      </tr>
        <%
        i++;
      }
    %>
    </table>
    </div>
  </body>
</html>
