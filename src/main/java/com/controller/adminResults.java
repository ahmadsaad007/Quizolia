package com.controller;

import com.dao.AdminUserSubmissionsDao;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class adminResults extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("username")==null || !session.getAttribute("username").equals("admin")){
            out.print("<div style='margin-top: 50px; color: crimson;'>Please sign in as Admin</div>");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        System.out.println("In Admin Results Servlet");
        List list = AdminUserSubmissionsDao.getUserResults();
        session.setAttribute("submissionsList", list);
        response.sendRedirect("/Quizolia_war/HTML/adminResults.jsp");
    }
}
