package com.controller;

import com.dao.QuizQuestionDao;
import com.dao.SubmissionDao;
import com.domain.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class submit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession(false);

        if(session == null || session.getAttribute("username")==null){
            out.print("<div style='margin-top: 50px; color: crimson;'>Please login first</div>");
            request.getRequestDispatcher("login.html").include(request, response);
        }

        String username = (String) session.getAttribute("username");
        String submissionId = username + session.getId();
        int quizID = (int) session.getAttribute("quizId");
        List<Question> questions = (List<Question>)session.getAttribute("questions");
        List<String> userSubmissions = (List<String>) session.getAttribute("userAnswer");


        int i = 0;int count = 0;
        while(i<questions.size()){
            //String question = questions.get(i).getText();
            String options[] = questions.get(i).getQuestionOptions().split(";");
            String userAnswer = userSubmissions.get(i);

            if(!userAnswer.equals(""))
                userAnswer = options[((Integer.parseInt(userSubmissions.get(i)))-1)];

            String correctAnswer = options[questions.get(i).getCorrectOptionIndex()];
            if(correctAnswer.equals(userAnswer))
                count++;
            i++;
        }
        if(count>=6){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        SubmissionDao.submit(submissionId, username, quizID,"","", count);
        //System.out.println("In Submit Servlet. Redirecting to final page!");
        i = 0;
        while(i<questions.size()){
            String options[] = questions.get(i).getQuestionOptions().split(";");
            String userAnswer = userSubmissions.get(i);
            if(!userAnswer.equals(""))
                userAnswer = options[((Integer.parseInt(userSubmissions.get(i)))-1)];
            int questionId = questions.get(i).getId();
            QuizQuestionDao.submit(questionId, submissionId,userAnswer);
            i++;
        }

        request.getRequestDispatcher("/HTML/home.jsp").include(request, response);

    }
}
