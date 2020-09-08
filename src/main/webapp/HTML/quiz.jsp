<%@ page import="com.domain.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>QUIZ</title>
    <link rel="stylesheet" type="text/css" href="/Quizolia_war/CSS/pageStyling.css">
</head>
<body>
<div class="container">
    <p id="question" ></p>
    <%
        List<Question> questions =
                (List<Question>)session.getAttribute("questions");
        int currentIndex = (int) session.getAttribute("currentIndex");
        List<String> userAnswer = (List<String>) session.getAttribute("userAnswer");

    %>
    <form method="post" action="nextSubmission">
        <div id="myDIV">
            <input type="radio" name="option" value="1"><p style="display:inline" id="option1"></p>
            <input type="radio" name="option" value="2"><p style="display:inline" id="option2"></p>
            <input type="radio" name="option" value="3"><p style="display:inline" id="option3"></p>
            <input type="radio" name="option" value="4"><p style="display:inline" id="option4"></p>
        </div>
        <div id="btns">
            <input id="prevBtn" type="submit" style="padding: 8px;" value="Prev" name="Prev">
            <input id ="nextBtn" type="submit" style="padding: 8px; display: inline-block;" value="Next" name="Next">
            <input id="submitBtn" style="padding: 8px; display: none;" type="submit" value="Submit" name="Submit">
        </div>
    </form>
    <p></p>
</div>
    <script>

        <%
        if(!userAnswer.get(currentIndex).equals("")){
            int checkBtnVal = Integer.parseInt(userAnswer.get(currentIndex));%>
            document.querySelector('[value="<%=checkBtnVal%>"]').checked = true;<%
        }
        %>

        var nextBtn = document.getElementById("nextBtn");
        var prevBtn = document.getElementById("prevBtn");

        //array of options
        var options = [<% for (int j = 0; j < questions.size(); j++) { %>"<%= questions.get(j).getQuestionOptions() %>"<%= j + 1 < questions.size() ? ",":"" %><% } %>];
        //array of questions
        var texts = [<% for (int j = 0; j < questions.size(); j++) { %>"<%= questions.get(j).getText() %>"<%= j + 1 < questions.size() ? ",":"" %><% } %>];

        var option1 = document.getElementById("option1");
        var option2 = document.getElementById("option2");
        var option3 = document.getElementById("option3");
        var option4 = document.getElementById("option4");


        var text=document.getElementById("question");
        var result = texts[<%=currentIndex%>];
        text.innerHTML = result;
        //get the options for the current question: "option1;option2; option3;option4"
        var optionValues = options[<%=currentIndex%>].split(";")
        option1.innerHTML = optionValues[0];
        option2.innerHTML = optionValues[1];
        option3.innerHTML = optionValues[2];
        option4.innerHTML = optionValues[3];
        console.log(result);
        console.log(<%=currentIndex %>);
        var len = (<%=currentIndex %>);
        var submit = document.getElementById("submitBtn");
        //if the question is not the first question, display the Prev button
        if(len>0)
            prevBtn.style.display = "inline-block";
        else{
            prevBtn.style.display = 'none';
        }
        if(len == texts.length -1){
            submit.style.display = "inline-block";
            nextBtn.style.display = "none";
        }
    </script>


</body>
</html>
