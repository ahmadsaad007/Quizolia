package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class userSubmissionController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        //get user selected option
        String option = (request.getParameter("option"));

        HttpSession session = request.getSession(false);
        if(option == null){
            option = "";
        }

        List<String> userAnswers = (List<String>) session.getAttribute("userAnswer");

        int currentIndex = (int) session.getAttribute("currentIndex");
        System.out.println("Current QNum= "+currentIndex+" User choose: "+option);


        if(request.getParameter("Next") != null){
            System.out.println("Next is pressed");
            userAnswers.set(currentIndex, option);
            currentIndex += 1;
            session.setAttribute("currentIndex", currentIndex);
            request.getRequestDispatcher("/HTML/quiz.jsp").forward(request,response);
        }else if(request.getParameter("Prev") != null){
            System.out.println("Prev is pressed");
            userAnswers.set(currentIndex, option);
            currentIndex -= 1;
            session.setAttribute("currentIndex", currentIndex);
            request.getRequestDispatcher("/HTML/quiz.jsp").forward(request,response);
        }
        else if(request.getParameter("Submit")!= null){
            System.out.println("Submit is pressed");
            userAnswers.set(currentIndex, option);
            currentIndex+=1;
            session.setAttribute("currentIndex", currentIndex);
            request.getRequestDispatcher("/HTML/submissionConfirm.jsp").forward(request,response);
        }

    }
}

