package com.controller;

import com.dao.FeedbackDao;
import com.domain.Feedback;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class readFeedback extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List feedback = FeedbackDao.getFeedback();
        HttpSession session = request.getSession(false);
        session.setAttribute("feedbacks", feedback);
        response.sendRedirect("/Quizolia_war/HTML/adminFeedback.jsp");
    }
}
