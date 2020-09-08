<%@ page import="com.domain.QuizSubmissions" %>
<%@ page import="java.util.List" %>
<%@ page import="com.domain.AdminQuizSubmission" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="adminLinks.html"%>
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
      <th>Username</th>
      <th>QuizId</th>
      <th>Result</th>
    </tr>
 <%
   List results = (List) session.getAttribute("submissionsList");
   int i = 0;
   while (i<results.size()){
        Object[] array = (Object[]) results.get(i);
        String submissionId = (String) array[0];
        String username = (String)array[1];
        int quizId = (int)(array[2]);
        int totalScore = (int)(array[3]);
 %>
    <tr>
      <td><%=submissionId%></td>
      <td><%=username%></td>
      <td><%=quizId%></td>
      <td><%=totalScore%></td>
    </tr>
      <%
      i++;
    }
  %>
  </div>
  </body>
</html>
