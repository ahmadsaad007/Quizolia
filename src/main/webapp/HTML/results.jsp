<%@ page import="com.domain.QuizSubmissions" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="link.html" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
  </head>

  <body>
  <div class="container">
    <table class = "table" >
    <tr id="heading">
      <th>SubmissionId</th>
      <th>QuizId</th>
      <th>Result</th>
    </tr>
  <%
    List<QuizSubmissions> results =
            (List<QuizSubmissions>)session.getAttribute("results");
    int i = 0;
    while (i<results.size()){
      String submissionId = results.get(i).getSubmissionId();
      int quizId = results.get(i).getQuizId();
      int totalScore = results.get(i).getTotalScore();
  %>
  <tr>
    <td><%=submissionId%></td>
    <td><%=quizId%></td>
    <td><%=totalScore%></td>
  </tr>
  <%
      i++;
    }
  %>
  </table>
  </div>
  </body>
</html>
