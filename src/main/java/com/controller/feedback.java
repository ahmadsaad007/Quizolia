package com.controller;

import com.dao.FeedbackDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class feedback extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String starValue = req.getParameter("rating");
        String comment = req.getParameter("text");

        if(starValue.equals("")){
            starValue = "0";
        }

        FeedbackDao.submitFeedback(Integer.parseInt(starValue),comment);

        out.println("<center> Thanks for the feedback</center>");
        resp.sendRedirect("/Quizolia_war//HTML/feedback.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("Does nothing");
    }
}
