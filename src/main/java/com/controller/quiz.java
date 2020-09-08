package com.controller;

import com.Exception.DaoException;
import com.dao.QuizDao;
import com.domain.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class quiz extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("username")==null){
            out.print("<div style='margin-top: 50px; color: crimson;'>Please login first</div>");
            request.getRequestDispatcher("login.html").include(request, response);
        }

        List questions = null;
        List<String> userAnswers = new ArrayList<>(Arrays.asList("","","","","","","","","",""));

        if(action.equals("java")){
            try {
                session.setAttribute("quizId",1);
                questions = QuizDao.getQuestionsByType("Java");//the question, the options and the correctIndex
                session.setAttribute("questions", questions);
                session.setAttribute("currentIndex", 0);
                session.setAttribute("userAnswer", userAnswers);
                System.out.println("Number of questions generated: "+ questions.size());

            } catch (DaoException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/HTML/quiz.jsp").forward(request,response);
        }
        else if(action.equals("math")){
            try {
                session.setAttribute("quizId",2);
                questions = QuizDao.getQuestionsByType("Math");//the question, the options and the correctIndex
                //List<String> userAnswers = new ArrayList<>(Arrays.asList("","","","","","","","","",""));
                session.setAttribute("questions", questions);
                session.setAttribute("currentIndex", 0);
                session.setAttribute("userAnswer", userAnswers);
                System.out.println("Number of questions generated: "+ questions.size());

            } catch (DaoException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/HTML/quiz.jsp").forward(request,response);
        }
        else if(action.equals("science")){
            try {
                session.setAttribute("quizId",3);
                questions = QuizDao.getQuestionsByType("Science");//the question, the options and the correctIndex
                session.setAttribute("questions", questions);
                session.setAttribute("currentIndex", 0);
                session.setAttribute("userAnswer", userAnswers);
                System.out.println("Number of questions generated: "+ questions.size());

            } catch (DaoException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/HTML/quiz.jsp").forward(request,response);
        }

    }

}
