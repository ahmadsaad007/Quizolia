<%@ page import="java.sql.Connection" %>
<%@ page import="com.dao.ConnectionProvider" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="adminLinks.html" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
  </head>
  <body>
  <div class="container">

    <h3>Active Users</h3>
    <table class = "table" >
      <tr id="heading">
        <th>Username</th>
        <th>Name</th>
        <th>Active Status</th>
      </tr>
  <%
    session = request.getSession(false);
    if(session == null || session.getAttribute("username")==null || !session.getAttribute("username").equals("admin")){
            out.print("<div style='margin-top: 50px; color: crimson;'>Please sign in as Admin</div>");
            request.getRequestDispatcher("login.html").include(request, response);
    }

    Connection connection = ConnectionProvider.getConnection();
    PreparedStatement statement = null;

    try {

      statement = connection.prepareStatement("SELECT * FROM users u");
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {%>

        <tr>
          <td><%=rs.getString("username")%></td>
          <td><%=rs.getString("fullName")%></td>
          <td><%=rs.getBoolean("isActive")%></td>
        </tr>
      <%
      }
    } catch (Exception e) {
      System.out.println("Exception Occured Connecting to DataBase");
    }%>

  </div>
  </body>
</html>
