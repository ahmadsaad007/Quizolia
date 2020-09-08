package com.controller;

import com.dao.AdminUserSubmissionsDao;
import com.domain.AdminQuizSubmission;
import com.domain.QuizSubmissions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class adminResults extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        System.out.println("In Admin Results Servlet");
        List list = AdminUserSubmissionsDao.getUserResults();
        session.setAttribute("submissionsList", list);
        response.sendRedirect("/Quizolia_war/HTML/adminResults.jsp");
    }
}
