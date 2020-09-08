<%@ page import="com.domain.Question" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
</head>
<body>

//<script>window.alert("Your quiz was submitted! Press Ok to view your answers");</script>
<div class="container">
    <%
        List<Question> questions =
                (List<Question>)session.getAttribute("questions");
        List<String> userSubmissions = (List<String>) session.getAttribute("userAnswer");


        int i = 0;int count = 0;
        while(i<questions.size()){

            System.out.println("Question Number: " + i);

            String question = questions.get(i).getText();
            String options[] = questions.get(i).getQuestionOptions().split(";");
            String userAnswer = userSubmissions.get(i);

            System.out.println("Option Value: " + userAnswer);

            if(!userAnswer.equals("")) {
                userAnswer = options[((Integer.parseInt(userSubmissions.get(i))) - 1)];
                System.out.println("Option Index After Parse: " + (Integer.parseInt(userSubmissions.get(i)) - 1));
            }
            String correctAnswer = options[questions.get(i).getCorrectOptionIndex()];

            System.out.println("Correct Answer "+ questions.get(i).getCorrectOptionIndex());

            if(correctAnswer.equals(userAnswer))
                count++;
    %>  <p> <%=question%> </p>
    <%--            <p><b>Options: </b> <%=options%></p>--%>
    <p><b>Your Submission: </b><%=userAnswer%></p>
    <p><b>Correct Submission: </b><%=correctAnswer%></p>
    <p></p>
    <%
            i++;
        }
        if(count>=6){
    %> <h3>YOU PASSED!</h3> <%
            System.out.println("Pass");
        }
        else {
    %> <h3>YOU FAILED!</h3> <%
        System.out.println("Fail");
        }
    %>
    <form method="post" action="submission">
        Press button to save the submission:
        <input id="submitBtn" type="submit" value="Save" name="Submit">
    </form>
</div>
</body>
</html>
