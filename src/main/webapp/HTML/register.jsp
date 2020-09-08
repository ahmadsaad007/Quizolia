<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/registerStyle.css">
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
</head>
<body>
<div class ="container">
<form method="post" action="${pageContext.request.contextPath}/register">
    Enter Username: <input class="textBox" type="text" name="username" /><p></p>
    Enter Password: <input class="textBox" type="password" name="password" /><p></p>
    Enter Full Name: <input class="textBox" type="text" name="name"><p></p>
    <input class="submitBtn" type="submit" value="Submit">
</form>
</div>
</body>
</html>